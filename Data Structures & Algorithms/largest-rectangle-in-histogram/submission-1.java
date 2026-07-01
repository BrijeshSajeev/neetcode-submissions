class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for(int i=0;i<heights.length;i++){
            int minHeight = heights[i];
            int w = 1;

            for(int j=i; j<heights.length;j++){
                minHeight = Math.min(minHeight, heights[j]);
                w = Math.max(w, j-i+1);
                maxArea = Math.max(maxArea, minHeight * w);
            }
        }

        return maxArea;
    }
}
