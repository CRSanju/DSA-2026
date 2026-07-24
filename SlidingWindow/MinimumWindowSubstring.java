package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

    }
    
    public static String minWindow(String s, String t) {
        
    	if(t.length() > s.length()) {
    		return "";
    	}
    	
    	HashMap<Character, Integer> map = new HashMap<>();
    	for(int i = 0; i < t.length(); i++) {
    		char ch = t.charAt(i);
    		map.put(ch, map.getOrDefault(ch, 0) + 1);
    	}
    	
    	int left = 0;
    	int minLength = Integer.MAX_VALUE;
    	int start = 0;
    	int count = t.length();
    	
    	for(int right = 0; right < s.length(); right++) {
    		char ch = s.charAt(right);
    		if(map.containsKey(ch)) {
    			if(map.get(ch) > 0) {
    				count--;
    			}
    			map.put(ch, map.get(ch) - 1);
    		}
    		
    		while(count == 0) {
    			int windowLength = right - left + 1;
    			if(windowLength < minLength) {
    				minLength = windowLength;
    				start = left;
    			}
    			
    			char lf = s.charAt(left);
    			if(map.containsKey(lf)) {
    				map.put(lf, map.get(lf) + 1);
    				if(map.get(lf) > 0) {
    					count++;
    				}
    			}
    			left++;
    		}
    	}

        return s.substring(start, start + minLength);
    }

}
