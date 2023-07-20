package leetcode.normal.j860;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lemonade-change/">860. 柠檬水找零</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] record = new int[3];
        for (int bill : bills) {
            if (bill == 20) {
                if (record[0] > 0 && record[1] > 0) {
                    --record[0];
                    --record[1];
                } else if (record[0] > 2) {
                    record[0] -= 3;
                } else return false;
                ++record[2];
            } else if (bill == 10) {
                if (record[0] > 0) {
                    --record[0];
                } else return false;
                ++record[1];
            } else {
                ++record[0];
            }
        }
        return true;
    }
}