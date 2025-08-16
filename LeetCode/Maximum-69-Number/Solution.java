class Solution {
    public int maximum69Number (int num) {
        // Convert number to string to easily manipulate digits
        char[] digits = String.valueOf(num).toCharArray();
        
        // Change the first '6' to '9' (most significant change)
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // change only once
            }
        }
        
        // Convert back to integer
        return Integer.parseInt(new String(digits));
        
    }
}