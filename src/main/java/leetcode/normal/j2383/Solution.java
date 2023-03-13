package leetcode.normal.j2383;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/">2383. 赢得比赛需要的最少训练时长</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int needExp = 0, curExp = initialExperience;
        for (int i = 0; i < energy.length; i++) {
            initialEnergy -= energy[i];
            if (curExp <= experience[i]) {
                needExp += experience[i] - curExp + 1;
                curExp += experience[i] - curExp + 1;
            }
            curExp += experience[i];
        }
        if (initialEnergy > 0) return needExp;
        else return -initialEnergy + 1 + needExp;
    }
}