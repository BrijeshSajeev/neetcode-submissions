class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // values will be stored as [[val, index], ...]
        // pq.peek()[0] -> represent the top value
        // pq.peek()[1] -> represent the top index

        int index = 0;

        for(int i = 0; i < n; i++){
            pq.offer(new int[]{nums[i], i});

            // 1 -> represent the index
            // pq.peek()[1] -> represent the top index
            while(pq.peek()[1] <= i - k){
                pq.poll();
            }

            if (i >= k - 1) {
                ans[index++] = pq.peek()[0];
            }
        }

        return ans;
    }
}
