class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            String oddSubstring = expandAroundCenter(s, i, i);
            String evenSubstring = expandAroundCenter(s, i, i+1);

            result = oddSubstring.length() > result.length() ? oddSubstring : result;
            result = evenSubstring.length() > result.length() ? evenSubstring : result;
        }

        return result;
    }

    private String expandAroundCenter(String s, int left, int right) {
    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }

    return s.substring(left+1, right);
  }
}
