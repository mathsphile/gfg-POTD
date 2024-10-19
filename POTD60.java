//A string str is given to represent a positive number. The task is to round str to the nearest multiple of 10.  If you have two multiples equally apart from str, choose the smallest element among them.

//A string str is given to represent a positive number.The task is to round str to the nearest multiple of 10. If you have two multiples equally apart from str,choose the smallest element among them.

import java.math.BigInteger;

class Solution {

    String roundToNearest(String str) {
        // Find and preserve leading zeros
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        String leadingZeros = str.substring(0, i);  // All leading zeros

        // Convert the non-zero part to BigInteger
        String numberWithoutLeadingZeros = str.substring(i);
        if (numberWithoutLeadingZeros.isEmpty()) {
            return leadingZeros + "0"; // If all are zeros, return "0"
        }

        BigInteger num = new BigInteger(numberWithoutLeadingZeros);

        // Find the remainder when divided by 10
        BigInteger ten = new BigInteger("10");
        BigInteger remainder = num.mod(ten);

        // Subtract remainder to round down
        BigInteger roundedDown = num.subtract(remainder);

        // Check if remainder is greater than or equal to 5
        if (remainder.compareTo(new BigInteger("5")) > 0) {
            // If remainder is greater than 5, round up by adding the difference to the next multiple of 10
            roundedDown = roundedDown.add(ten);
        }

        // Return the result with leading zeros preserved
        return leadingZeros + roundedDown.toString();
    }
}
