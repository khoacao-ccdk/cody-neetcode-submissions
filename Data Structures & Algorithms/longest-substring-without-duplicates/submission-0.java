class Solution {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> seenMap = new HashMap<>();

    int result = 0;
    int l = 0;

    for(int r = 0; r < s.length(); r++) {
        char c = s.charAt(r);
        
        if(seenMap.containsKey(c) && seenMap.get(c) >= l) {
           l = seenMap.get(c) + 1;
        }

        result = Math.max(r - l + 1, result);
        seenMap.put(c, r);
    }

    return result;
  }
}
