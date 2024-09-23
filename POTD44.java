// Given an unsorted array arr of of positive integers.One number'A'from set{1,2,....,n}is missing and one number'B'occurs twice in array.Find numbers A and B.fill in the blanks


class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int[] result = new int[2]; // result[0] will store the duplicate, result[1] will store the missing number

        // Step 1: Mark visited elements using negation.
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;

            // If the number at 'index' is already negative, it means 'arr[i]' is the
            // duplicate number
            if (arr[index] < 0) {
                result[0] = Math.abs(arr[i]);
            } else {
                arr[index] = -arr[index]; // Mark as visited by making it negative
            }
        }

        // Step 2: Find the missing number
        for (int i = 0; i < n; i++) {
            // If the number is positive, it means the index+1 is the missing number
            if (arr[i] > 0) {
                result[1] = i + 1;
            }
        }

        return result;
    }
}