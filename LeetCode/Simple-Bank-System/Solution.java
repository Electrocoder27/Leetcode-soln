class Bank {
    private long[] balance;  // store balances for all accounts
    private int n;           // number of accounts

    // Constructor
    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }

    // Helper function to validate account number
    private boolean valid(int account) {
        return account >= 1 && account <= n;
    }

    // Withdraw money
    public boolean withdraw(int account, long money) {
        if (!valid(account)) return false;  // invalid account
        if (balance[account - 1] < money) return false;  // insufficient funds
        balance[account - 1] -= money;
        return true;
    }

    // Deposit money
    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    // Transfer money
    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) return false;
        if (balance[account1 - 1] < money) return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }
}
/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */