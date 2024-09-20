// Given an array height representing the heights of buildings.You have to count the buildings that will see the sunrise(Assume the sun rises on the side of the array starting point).Note:The height of the building should be strictly greater than the height of the buildings left in order to see the sun.

class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        int count = 0;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                count++;
                maxHeight = height[i];
            }
        }

        return count;
    }
}