class Solution {
  public int rob(int[] nums) {
    if(nums.length < 3) {
        return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
    }

    int[] maxRob = new int[nums.length];
    maxRob[0] = nums[0];
    maxRob[1] = Math.max(nums[1], nums[0]);

    for(int i = 2; i < nums.length; i++) {
        maxRob[i] = Math.max(nums[i] + maxRob[i-2], maxRob[i-1]);
    }

    return maxRob[nums.length-1];
  }
}
