class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    // Total gas could not cover the whole trip
    if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
      return -1;

    int tankSize = 0;
    int res = 0;
    for(int i = 0; i < gas.length; i++) {
      tankSize += gas[i] - cost[i];
      if(tankSize < 0) {
        tankSize = 0;
        res = i+1;
      }

    }

    return res;
  }
}
