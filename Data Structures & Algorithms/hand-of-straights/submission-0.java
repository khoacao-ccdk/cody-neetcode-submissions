class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    Arrays.sort(hand);

    Map<Integer, Integer> map = new HashMap<>();

    for (int card : hand) {
      int freq = map.getOrDefault(card, 0) + 1;
      map.put(card, freq);
    }

    for (int card : hand) {
      // This was used previously to form array
      if (!map.containsKey(card))
        continue;

      // Start forming the array
      for (int i = 0; i < groupSize; i++) {
        int cardNeeded = card + i;
        if (!map.containsKey(cardNeeded)) {
          return false;
        }

        int newFreq = map.get(cardNeeded) - 1;
        if (newFreq == 0) {
          map.remove(cardNeeded); // We used up all the card with this value
        } else {
          map.put(cardNeeded, newFreq); // Update the frequency map
        }
      }
    }

    return true;
  }
}
