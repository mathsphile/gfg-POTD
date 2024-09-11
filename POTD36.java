// Given an array arr containing the lengths of the different ropes, we need to connect these ropes to form one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // Create a priority queue (min-heap)
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // Insert all the ropes' lengths into the priority queue
        for (long length : arr) {
            pq.add(length);
        }

        long totalCost = 0;

        // While there are more than one rope left to connect
        while (pq.size() > 1) {
            // Extract the two smallest ropes
            long first = pq.poll();
            long second = pq.poll();

            // Calculate the cost of connecting them
            long cost = first + second;

            // Add the cost to the total cost
            totalCost += cost;

            // Insert the connected rope back into the priority queue
            pq.add(cost);
        }

        // Return the total cost
        return totalCost;
    }
}