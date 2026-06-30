class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(points.length, (a,b) -> 
        {
            double point1 = Math.sqrt(a[0] * a[0] + a[1] * a[1]);
            double point2 = Math.sqrt(b[0] * b[0] + b[1] * b[1]);

            return Double.compare(point1, point2);
        });

        for(int[] point : points) {
            pq.add(point);
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
