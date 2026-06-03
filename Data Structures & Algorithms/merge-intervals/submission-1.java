class Solution {
  public int[][] merge(int[][] intervals) {
    if(intervals.length == 1) return intervals;

    LinkedList<int[]> ll = new LinkedList<>();
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

    for(int[] interval : intervals) {
        int[] curr = interval;
        while(!ll.isEmpty() && ll.peekLast()[1] >= curr[0]) {
            int[] peek = ll.pollLast();
            curr[0] = Math.min(curr[0], peek[0]);
            curr[1] = Math.max(curr[1], peek[1]);
        }

        ll.offerLast(curr);
    }

    int[][] result = new int[ll.size()][2];
    for(int i = 0; i < result.length; i++) {
        result[i] = ll.pollFirst();
    }

    return result;
  }
}
