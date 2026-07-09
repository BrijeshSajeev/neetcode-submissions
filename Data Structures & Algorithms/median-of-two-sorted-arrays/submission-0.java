class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr= new int[n+m];

        int i = 0, j=0;
        int t =0;

        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                arr[t] = nums1[i];
                i++;
            }else{
                arr[t] = nums2[j];
                j++;
            }

            t++;
        }

        while(i < n){
            arr[t] = nums1[i];
            i++;
            t++;
        }

        while(j <m){
            arr[t] = nums2[j];
            j++;
            t++;
        }

        int size = arr.length;

        if (size % 2 == 1) {
            return arr[size / 2];
        }

        return (arr[size / 2 - 1] + arr[size / 2]) / 2.0;
    }
}
