// You are given an Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
       // Create an adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate the adjacency list with the given edges
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u); // Since the graph is undirected
        }
        
        // Array to store the shortest distance from src to each vertex
        int[] dist = new int[n];
        Arrays.fill(dist, -1); // Initialize distances to -1 (indicating unreachable)
        dist[src] = 0; // Distance from source to itself is 0
        
        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDist = dist[node];
            
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) { // If the neighbor hasn't been visited
                    dist[neighbor] = currentDist + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return dist;
    }
}