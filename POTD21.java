// Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
// Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Step 1: Create an adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        // Step 2: Fill the adjacency list by comparing adjacent words
        for(int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());
            
            for(int j = 0; j < len; j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        // Step 3: Perform topological sort using Kahn's algorithm (BFS) or DFS
        int[] inDegree = new int[K];
        for(int i = 0; i < K; i++) {
            for(int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < K; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        StringBuilder order = new StringBuilder();
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            order.append((char)(curr + 'a'));
            
            for(int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Step 4: Return the topological order as a string
        if(order.length() == K) {
            return order.toString();
        } else {
            return ""; // If a valid order is not possible
        }
        
        
    }
}
