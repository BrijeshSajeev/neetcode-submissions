class Solution {
    public int longestConsecutive(int[] nums) {
        // Base case: an empty array has a sequence length of 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> st = new HashSet<>();
        
        // Store all the value in hashSet
        for(Integer n: nums){
            st.add(n);
        }

        int maxStreak = 0;

        for(Integer num : st){
            if(!st.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                // Step 4: Count how far this sequence goes
                while (st.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Step 5: Track the maximum sequence found
                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }
        return maxStreak;
    }
}
