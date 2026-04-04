class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder sb = new StringBuilder();

        // Traverse diagonals
        for (int col = 0; col < cols; col++) {
            int i = 0;
            int j = col;

            while (i < rows && j < cols) {
                sb.append(encodedText.charAt(i * cols + j));
                i++;
                j++;
            }
        }

        // Remove trailing spaces
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }

        return sb.substring(0, end + 1);
    }
}