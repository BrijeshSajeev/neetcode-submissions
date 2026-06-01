class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return false;

        HashSet<Integer> ans = new HashSet<Integer>();

        for(int i =0; i< nums.length; i++){
            if(ans.contains(nums[i])){
                return true;
            }

            ans.add(nums[i]);
        }

        return false;
    }
}