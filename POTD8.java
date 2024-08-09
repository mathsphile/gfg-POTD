class Solution {

    int Maximize(int arr[]) {
        // Sort the array
        Arrays.sort(arr);

        long result = 0;
        int mod = 1000000007;

        // Calculate the sum of arr[i] * i
        for (int i = 0; i < arr.length; i++) {
            result = (result + (long) arr[i] * i) % mod;
        }

        return (int) result;
    }
}