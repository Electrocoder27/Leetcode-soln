class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;  // total bottles drunk
        int empty = numBottles;  // empty bottles after drinking

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;  // how many full bottles we can get
            count += newBottles;                   // drink them
            empty = empty % numExchange + newBottles; // leftover empty + newly drunk empties
        }

        return count;
    }
}