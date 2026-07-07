class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] coinsNeeded = new int[amount + 1];
    Arrays.fill(coinsNeeded, amount+1);
    coinsNeeded[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          coinsNeeded[i] = Math.min(coinsNeeded[i], 1 + coinsNeeded[i - coin]);
        }
      }
    }

    return coinsNeeded[amount] > amount ? -1 : coinsNeeded[amount];
  }
}
