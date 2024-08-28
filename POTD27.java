// Given an array of integers arr, sort the array according to the frequency of elements, i.e. elements that have higher frequency comes /////first. If the frequencies of two elements are the same, then the smaller number comes first.

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
         // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        // Populate the frequency map
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a list from the array elements
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }
        
        // Sort the list based on the frequency and value
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqA = freqMap.get(a);
                int freqB = freqMap.get(b);
                
                // If frequencies are different, sort by frequency in descending order
                if (freqA != freqB) {
                    return freqB - freqA;
                }
                
                // If frequencies are the same, sort by value in ascending order
                return a - b;
            }
        });
        
        return result;
    }
}