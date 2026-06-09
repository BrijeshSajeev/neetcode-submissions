class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Brute Force method.
        Set<List<Integer>> st = new HashSet<>();;
        int n = nums.length;

        for(int i=0;i<n; i++){
            for(int j =i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] ==0){
                        List<Integer> temp = new ArrayList<>(List.of(nums[i], nums[j], nums[k])); 
                        
                        // 2. Sort it so duplicate triplets look identical (e.g., [-1, 0, 1])
                        Collections.sort(temp); 
                        
                        // 3. Use .add() instead of .push()
                        st.add(temp); 
                    }
                }
            }
        }

       List<List<Integer>> ans = new ArrayList<>(st);

        return ans;
    }
}
