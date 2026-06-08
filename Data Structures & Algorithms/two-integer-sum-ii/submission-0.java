class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i =0;
        int j = numbers.length -1;

        while(i < j){
            if(numbers[i] + numbers[j] > target){
                j--;
                continue;
            }

            if(numbers[i] + numbers[j] == target){
                return new int[] { i+1, j+1 };
            }

            i++;
        }

        return new int[] { };
    }
}
