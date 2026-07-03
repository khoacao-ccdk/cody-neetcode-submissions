class Solution {
  public int maxProduct(int[] nums) {
    int res = nums[0];
    int curMin = 1, curMax = 1;

    for (int num : nums) {
      int curr = num * curMax;

      curMax = Math.max(Math.max(num * curMax, num * curMin), num);
      curMin = Math.min(Math.min(curr, num * curMin), num);

      res = Math.max(curMax, res);
    }

    return res;
  }
}
