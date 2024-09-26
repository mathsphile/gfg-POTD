// You are given the heights of consecutive buildings. You can move from the roof of a building to the roof of the next adjacent building. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.


class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Initialize variables to keep track of the current and maximum steps
        int maxSteps = 0;
        int currentSteps = 0;

        // Iterate through the array
        for (int i = 1; i < arr.length; i++) {
            // Check if the current building is taller than the previous one
            if (arr[i] > arr[i - 1]) {
                // Increment current step count
                currentSteps++;
            } else {
                // Reset the current step count
                currentSteps = 0;
            }

            // Update maximum steps
            maxSteps = Math.max(maxSteps, currentSteps);
        }

        return maxSteps;
    }
}