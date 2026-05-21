class Solution {
  public List<Integer> partitionLabels(String s) {
    Map<Character, Integer> lastSeen = new HashMap<>();

    List<Integer> result = new ArrayList<>();
    char[] cArr = s.toCharArray();
    int l = 0, r = 0;

    for (int i = 0; i < cArr.length; i++) {
      lastSeen.put(cArr[i], i);
    }

    while (l < cArr.length) {
      r = lastSeen.get(cArr[l]);
      for (int i = l; i < r; i++) {
        r = Math.max(r, lastSeen.get(cArr[i]));
      }
      result.add(r - l + 1);
      l = r + 1;
    }

    return result;
  }
}
