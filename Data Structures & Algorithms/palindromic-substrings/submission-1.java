class Solution {
  public int countSubstrings(String s) {
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
        result += expand(s, i, i);
        result += expand(s, i, i+1);
    }

    return result;
  }

  private int expand(String s, int l, int r) {
    int numString = 0;

    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
      numString++;
    }

    return numString;
  }
}
