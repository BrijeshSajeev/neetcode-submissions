class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i =0;i<prices.length;i++){
            int sum = 0;
            for(int j=i+1; j<prices.length;j++){
                sum = prices[j] - prices[i];

                if(prices[j] - prices[i] > 0) profit = Math.max(sum, profit);
            }

            profit = Math.max(sum, profit);
        }

        return profit;
    }
}
