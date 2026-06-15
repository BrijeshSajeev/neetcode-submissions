class Solution {
    public int maxArea(int[] heights) {
        int area = 0;

        for(int i=0;i<heights.length;i++){
            int h = 0;
            int w = 0;

            for(int j=i+1; j<heights.length; j++){
                h = Math.min(heights[i], heights[j]);
                w = (j+1) - (i + 1);

                area = Math.max(area, h*w);
            }
        }

        return area;
    }
}
