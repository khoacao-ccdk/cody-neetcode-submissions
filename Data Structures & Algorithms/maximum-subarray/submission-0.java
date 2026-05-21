class Solution {
  public int maxSubArray(int[] nums) {
    int maxSum = nums[0], localSum = maxSum;

    for (int i = 1; i < nums.length; i++) {
      localSum = Math.max(nums[i], nums[i] + localSum);

      maxSum = Math.max(maxSum, localSum);
    }

    return maxSum;
  }
}
