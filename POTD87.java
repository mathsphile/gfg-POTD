//Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

//Note: Stock must be bought before being sold.

class Solution {
    public int maximumProfit(int prices[]) {
        if (prices == null || prices.length == 0) {
            return 0; // No profit can be made if there are no prices
        }

        int minPrice = Integer.MAX_VALUE; // Track the minimum price seen so far
        int maxProfit = 0; // Initialize the maximum profit to 0

        for (int price : prices) {
            // Update the minimum price
            minPrice = Math.min(minPrice, price);

            // Calculate the current profit and update the maximum profit
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit; // Return the maximum profit
    }
}
