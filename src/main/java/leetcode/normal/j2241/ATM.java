package leetcode.normal.j2241;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-an-atm-machine/description/">2241. 设计一个 ATM 机器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class ATM {
    int[] bankVal = {20, 50, 100, 200, 500};
    int[] bankCount;

    public ATM() {
        bankCount = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) bankCount[i] += banknotesCount[i];
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (bankCount[i] > 0) {
                int cnt = Math.min(amount / bankVal[i], bankCount[i]);
                res[i] += cnt;
                amount -= cnt * bankVal[i];
            }
        }
        if (amount == 0) {
            for (int i = 0; i < 5; i++) bankCount[i] -= res[i];
            return res;
        } else {
            return new int[]{-1};
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */