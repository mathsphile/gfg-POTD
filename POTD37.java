//Given an unsorted array arr containing both positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
// Note: Array should start with a positive number and 0 (zero) should be considered a positive element.

class Solution {
    void rearrange(ArrayList<Integer> arr) {

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        int posIndex = 0, negIndex = 0, i = 0;
        boolean positiveTurn = true;

        // Alternate positive and negative numbers
        while (posIndex < positive.size() && negIndex < negative.size()) {
            if (positiveTurn) {
                arr.set(i++, positive.get(posIndex++));
            } else {
                arr.set(i++, negative.get(negIndex++));
            }
            positiveTurn = !positiveTurn;
        }

        // If there are remaining positive numbers
        while (posIndex < positive.size()) {
            arr.set(i++, positive.get(posIndex++));
        }

        // If there are remaining negative numbers
        while (negIndex < negative.size()) {
            arr.set(i++, negative.get(negIndex++));
        }
    }
}