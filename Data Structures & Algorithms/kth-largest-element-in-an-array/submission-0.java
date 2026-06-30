class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(nums.length, (a,b) -> Integer.compare(b, a));

        for(int num : nums) {
            pq.add(num);
        }

        while(--k > 0) {
            pq.poll();
        }

        return pq.peek();
    }
}
