class Solution {
    public int distMoney(int money, int children) {
        // Not enough money for 1 dollar each
        if (money < children) return -1;
        // Special impossible case: one child and money == 4 -> would give 4
        if (children == 1) {
            return money == 8 ? 1 : -1;
        }

        int remaining = money - children;         // extra dollars to allocate after giving everyone $1
        int max8 = Math.min(remaining / 7, children); // each 8 requires +7 extra

        // leftover dollars after making max8 children have 8
        int leftover = remaining - max8 * 7;

        // If everyone is 8 but there is leftover money -> we must reduce one 8 because there's no extra child to take leftover
        if (max8 == children && leftover > 0) {
            max8--;
            leftover += 7; // technically not needed for return, but shows we gave up one 8 -> freed 7 extra
        }

        // If leftover == 3 while exactly one child is not 8 (i.e., max8 == children - 1),
        // that leftover child would end up with 4 (1 + 3) which is forbidden -> reduce one 8
        if (leftover == 3 && max8 == children - 1) {
            max8--;
        }

        return max8;
    }
}
