class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        int totalWindows = nums.length - k + 1;
        int[] ans = new int[totalWindows];
        
        int right = k;
        for(int i=0; i<= nums.length - k; i++){
            ans[i] = max(nums, i, right);
            right++;
        }

        return ans;
    }

    public int max(int[] arr, int l, int r){
        int max = arr[l];

        for(int i=l+1; i<r;i++){
            if(max < arr[i]) max = arr[i];
        }

        return max;
    }
}
