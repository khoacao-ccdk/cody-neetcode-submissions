class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] coinsNeeded = new int[amount+1];
    coinsNeeded[0] = 0;

    for (int i = 1; i <= amount; i++) {
        coinsNeeded[i] = -1;
    }

    for(int a = 1; a <= amount; a++) {
        int minCoin = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(a - coin < 0) continue;
            int nextStep = coinsNeeded[a - coin];
            if(nextStep == -1) continue;
        
            minCoin = Math.min(minCoin, 1 + nextStep);
        }
        coinsNeeded[a] = minCoin != Integer.MAX_VALUE ? minCoin : -1;
    }


    return coinsNeeded[amount];
  }
}
