class Solution {
  public boolean mergeTriplets(int[][] triplets, int[] target) {
    int max0=0, max1=0, max2=0;
    for (int[] triplet : triplets) {
      if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
        continue;
      }

      max0 = Math.max(triplet[0], max0);
      max1 = Math.max(triplet[1], max1);
      max2 = Math.max(triplet[2], max2);
    }

    return max0 == target[0] && max1 == target[1] && max2 == target[2];
  }
}
