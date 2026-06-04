class Solution {
  public int rob(int[] nums) {
    if(nums.length < 3) {
        return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
    }

    int robFirstHouse = robHelper(nums, 0, nums.length - 2); 
    int robLastHouse = robHelper(nums, 1, nums.length - 1);

    return Math.max(robFirstHouse, robLastHouse);
  }

  private int robHelper(int[] nums, int start, int end) {
    int prev2 = 0, prev1 = 0;

    for(int i = start; i <= end; i++) {
        int temp = Math.max(prev1, prev2 + nums[i]);

        prev2 = prev1;
        prev1 = temp;
    }

    return prev1;
  }
}
