// Given two positive integer arrays arr and brr, find the number of pairs such that xy > yx (raised to power of) where x is an element from arr and y is an element from brr.

class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // Sort array y
        Arrays.sort(y);

        // Count occurrences of 0, 1, 2, 3, and 4 in array y
        int[] count = new int[5];
        for (int num : y) {
            if (num < 5) {
                count[num]++;
            }
        }

        long result = 0;

        // Iterate through array x
        for (int i = 0; i < M; i++) {
            result += count(x[i], y, N, count);
        }

        return result;
    }

    private long count(int x, int[] y, int n, int[] count) {
        if (x == 0)
            return 0;
        if (x == 1)
            return count[0];

        int index = upperBound(y, n, x);
        long answer = n - index;

        answer += count[0] + count[1];

        if (x == 2) {
            answer -= count[3] + count[4];
        }

        if (x == 3) {
            answer += count[2];
        }

        return answer;
    }

    private int upperBound(int[] arr, int n, int value) {
        int low = 0, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (value >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}