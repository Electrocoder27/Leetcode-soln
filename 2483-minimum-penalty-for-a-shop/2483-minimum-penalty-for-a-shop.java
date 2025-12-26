class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        // Count total Y's first (we assume shop is closed at hour 0 initially)
        int totalY = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') totalY++;
        }

        int minPenalty = totalY;  // penalty if we close at hour 0 (all Y's become lost customers)
        int bestHour = 0;

        int openN = 0;  // how many 'N' when shop is open
        int closedY = totalY; // how many 'Y' after closing time

        // Try closing at every hour j from 1 to n
        for (int j = 1; j <= n; j++) {
            // before closing at hour j, hour j-1 is open:
            if (customers.charAt(j - 1) == 'Y') {
                closedY--;  // one less Y in closed section
            } else {
                openN++;    // one more N in open section
            }

            int penalty = openN + closedY;
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;

        }
}