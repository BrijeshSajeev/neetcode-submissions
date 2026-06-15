class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int i =0;
        int j = heights.length - 1;
        
        while(i < j){
            int h = Math.min(heights[i], heights[j]);
            int w = (j+1) - (i+1);

            area = Math.max(area, h*w);
            if(heights[i] < heights[j])
            {
                i++;
            }else{
                j--;
            }
        }
        
        return area;
    }
}
