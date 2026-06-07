class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().replace(" ", "").toCharArray();

        System.out.println(Arrays.toString(arr));

        int i=0;
        int j= arr.length -1;

        while(i <= j){
            // Skip non-alphanumeric characters from the left
            if (!Character.isLetterOrDigit(arr[i])) {
                i++;
                continue; // Move to the next iteration of the loop
            }

            // Skip non-alphanumeric characters from the right
            if (!Character.isLetterOrDigit(arr[j])) {
                j--;
                continue; // Move to the next iteration of the loop
            }

            if(arr[i] != arr[j]){
                return false;
            }

            i++;
            j--;

        }        

        return true;
    }
}
