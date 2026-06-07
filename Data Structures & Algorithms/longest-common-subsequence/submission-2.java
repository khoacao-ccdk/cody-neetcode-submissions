class Solution {
  private int[][] memo;

  public int longestCommonSubsequence(String text1, String text2) {
    memo = new int[text1.length()][text2.length()];
    for (int i = 0; i < memo.length; i++) {
      Arrays.fill(memo[i], -1);
    }

    return dfs(text1, text2, 0, 0);
  }

  private int dfs(String s1, String s2, int i1, int i2) {
    if (i1 == s1.length() || i2 == s2.length())
      return 0;

    if (memo[i1][i2] != -1)
      return memo[i1][i2];

    if (s1.charAt(i1) == s2.charAt(i2)) {
      memo[i1][i2] = 1 + dfs(s1, s2, i1 + 1, i2 + 1);
    }

    else {
      memo[i1][i2] = Math.max(dfs(s1, s2, i1 + 1, i2), dfs(s1, s2, i1, i2 + 1));
    }

    return memo[i1][i2];
  }
}
