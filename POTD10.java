class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sorting jobs based on decreasing order of profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        // Find the maximum deadline among all jobs
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }
        
        // Initialize the result arrays for job scheduling
        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1); // -1 indicates the slot is free
        
        int jobCount = 0;
        int maxProfit = 0;
        
        // Iterating over all jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (starting from the last possible slot)
            for (int j = arr[i].deadline; j > 0; j--) {
                // If the slot is free
                if (result[j] == -1) {
                    result[j] = i;  // Mark this slot as occupied
                    jobCount++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[]{jobCount, maxProfit};
    }
}
