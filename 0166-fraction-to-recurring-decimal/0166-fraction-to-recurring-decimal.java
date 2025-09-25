class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        
        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integer part
        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return sb.toString(); // no fractional part
        
        sb.append(".");
        
        // Map to store remainder -> index in sb
        Map<Long, Integer> map = new HashMap<>();
        
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int idx = map.get(remainder);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
            
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }
        
        return sb.toString();
    }
}