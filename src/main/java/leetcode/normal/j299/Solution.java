package leetcode.normal.j299;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/bulls-and-cows/
 * 299. 猜数字游戏
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int ansA = 0, ansB = 0;
        int[] arrA = new int[10], arrB = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) ansA++;
            else {
                arrA[secret.charAt(i) - '0']++;
                arrB[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            ansB += Math.min(arrA[i], arrB[i]);
        }
        return ansA + "A" + ansB + "B";
    }
}
