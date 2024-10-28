// Given an array arr consisting of positive integer numbers, remove all duplicate numbers.

class Solution {
    ArrayList<Integer> removeDuplicate(int arr[]) {
         // Using HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            // If the element is not in the set, add it to both set and result list
            if (set.add(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
