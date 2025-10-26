package leetcode.normal.j2043;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/simple-bank-system/">2043. 简易银行系统</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Bank {
    long[] balance;
    int n;

    public Bank(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > n || account2 > n) return false;
        if (balance[account1 - 1] >= money) {
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account > n) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > n) return false;
        if (balance[account - 1] >= money) {
            balance[account - 1] -= money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */