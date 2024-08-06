// You are given a string str in the form of an IPv4 Address. Your task is to validate an IPv4 Address, if it is valid return true otherwise return false.

// IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1

// A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255. Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)

// Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.
    
class Solution {

    public boolean isValid(String str) {
        // Split the string into parts using the dot as a delimiter
        String[] parts = str.split("\\.");

        // There must be exactly 4 parts for a valid IPv4 address
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            // Check if the part is a valid integer representation
            // It must not be empty and must be a number
            if (part.isEmpty() || !part.matches("\\d+")) {
                return false;
            }

            // Convert the part to an integer
            int num = Integer.parseInt(part);

            // Check if the number is within the valid range (0-255)
            if (num < 0 || num > 255) {
                return false;
            }

            // Check for leading zeros: the part should be equal to its integer
            // representation
            // This handles cases like "01", "001", etc.
            if (part.length() != String.valueOf(num).length()) {
                return false;
            }
        }

        // If all parts are valid, return true
        return true;
        
    }
}
