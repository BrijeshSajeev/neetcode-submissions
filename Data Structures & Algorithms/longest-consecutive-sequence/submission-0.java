class Solution {
    public int longestConsecutive(int[] nums) {
         // Fix 1: Handle empty array boundary condition
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int i = 0;
        int max = 1;
        int count = 1;

        while (i < nums.length - 1) {
            // Skip duplicates safely
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }

            // Consecutive numbers found
            if (nums[i + 1] - nums[i] == 1) {
                count++;
                i++;
                continue;
            }
            
            // Sequence broke: record the max and reset count
            max = Math.max(max, count);
            count = 1; // Fix 2: Reset to 1, not 0
            i++;
        }

        return Math.max(max, count);
    }
}
