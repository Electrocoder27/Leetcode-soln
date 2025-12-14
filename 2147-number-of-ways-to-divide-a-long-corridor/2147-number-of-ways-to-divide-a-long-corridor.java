class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }

        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;

        long ways = 1;
        int seatsSeen = 0;
        int plants = 0;
        boolean counting = false;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatsSeen++;

                // If we were counting plants, finalize this gap
                if (counting) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                    counting = false;
                }

                // Start counting plants after every pair except last
                if (seatsSeen % 2 == 0 && seatsSeen != totalSeats) {
                    counting = true;
                }
            } 
            else if (counting) {
                plants++;
            }
        }

        return (int) ways;
    }
}