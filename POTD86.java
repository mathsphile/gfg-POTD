//The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.

//Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day. POTD86 {
    
class Solution {
    public int maximumProfit(int prices[]) {
        // Initialize profit to 0
        int profit = 0;

        // Loop through the array to calculate profit
        for (int i = 1; i < prices.length; i++) {
            // If the price of the current day is greater than the previous day
            if (prices[i] > prices[i - 1]) {
                // Add the difference to profit
                profit += prices[i] - prices[i - 1];
            }
        }

        // Return the total profit
        return profit;
    }
}

