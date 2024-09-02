Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
// From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  

public class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
     
        int n = grid.length;
        int[][] dist = new int[n][n];
        
        // Filling the distance array with a large value initially.
        for(int[] row: dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        // Priority queue to store {cost, x, y}, where cost is the total cost to reach (x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Starting with the top-left cell.
        pq.add(new int[]{grid[0][0], 0, 0});
        dist[0][0] = grid[0][0];
        
        // Directions for moving left, right, up, and down.
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], x = curr[1], y = curr[2];
            
            // If we've reached the bottom-right cell, return the cost.
            if(x == n - 1 && y == n - 1)
                return cost;
            
            // Exploring all four possible directions.
            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // Check if the new cell is within the grid bounds.
                if(newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = cost + grid[newX][newY];
                    
                    // If a cheaper cost to reach (newX, newY) is found, update and add to the queue.
                    if(newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.add(new int[]{newCost, newX, newY});
                    }
                }
            }
        }
        
        return -1; // In case there is no path, although per problem description there should always be one.
    }
    
} POTD32 {
    
}
