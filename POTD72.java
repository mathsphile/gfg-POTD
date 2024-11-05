//Given an array arr[], find all possible indices [i, j, k] of triplets [arr[i], arr[j], arr[k]] in the array whose sum is equal to zero. Return indices of triplets in any order and all the returned triplets indices should also be internally sorted, i.e., for any triplet indices [i, j, k], the condition i < j < k should hold.

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        // Iterate over each element to use it as the first element of a potential triplet
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // Check if the sum of arr[i], arr[j], and arr[k] is zero
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> triplet = Arrays.asList(i, j, k);
                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }
}