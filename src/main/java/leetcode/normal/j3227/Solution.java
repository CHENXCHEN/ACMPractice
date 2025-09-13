package leetcode.normal.j3227;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/vowels-game-in-a-string/description/">3227. 字符串元音游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean doesAliceWin(String s) {
        // 如果字符串中有奇数个元音字符，那么小红可以直接一把全部删掉
        // 如果字符串中有偶数个元音字符，那么小红可以先删除奇数个字符，留一个奇数，小明无法删掉它，下一个回合小红可以全部删除
        // 如果字符串中没有元音字符，那么小红无法操作，小明可以删掉全部
        return s.chars().anyMatch(ch -> "aeiou".indexOf(ch) != -1);
    }
}