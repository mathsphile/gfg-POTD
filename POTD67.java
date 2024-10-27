//Given an array arr of integers. Find whether three numbers are such that the sum of two elements equals the third element.



// Step 1: Sort the array
        Arrays.sort(arr);
        int n = arr.length;
        
        // Step 2: Loop through each element in the array, starting from the end
        for (int i = n - 1; i >= 2; i--) {
            int target = arr[i];
            int left = 0;
            int right = i - 1;
            
            // Step 3: Use two-pointer approach to find two numbers that sum up to target
            while (left < right) {
                int currentSum = arr[left] + arr[right];
                if (currentSum == target) {
                    return true;  // Found the triplet
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return false;  // No such triplet found
    