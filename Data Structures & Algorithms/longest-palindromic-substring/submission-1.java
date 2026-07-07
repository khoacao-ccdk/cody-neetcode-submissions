class Solution {
  public String longestPalindrome(String s) {
    String result = "";

    for (int i = 0; i < s.length(); i++) {
      String oddPalindrome = expand(s, i, i);
      String evenPalindrome = expand(s, i, i + 1);

      if (oddPalindrome.length() > result.length())
        result = oddPalindrome;

      if (evenPalindrome.length() > result.length())
        result = evenPalindrome;
    }

    return result;
  }

  private String expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }

    return s.substring(left+1, right);
  }
}
