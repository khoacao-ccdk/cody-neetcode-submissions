class Solution {
  public int jump(int[] nums) {
    int l = 0, r = 0;
    int numSteps = 0;
    while (r < nums.length - 1) {
      int maxDist = l;
      for (int i = l; i <= r; i++) {
        maxDist = Math.max(i + nums[i], maxDist);
      }

      l = r+1;
      r = maxDist;
      numSteps++;
    }

    return numSteps;
  }
}
