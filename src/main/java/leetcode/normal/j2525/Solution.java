package leetcode.normal.j2525;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/categorize-box-according-to-criteria/description/">2525. 根据规则将箱子分类</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long vol = (long) length * width * height;
        boolean isBulky = length >= 10000 || width >= 10000 || height >= 10000 || vol >= 1000000000,
                isHeavy = mass >= 100;
        if (isHeavy && isBulky) return "Both";
        else if (!isHeavy && !isBulky) return "Neither";
        else if (isBulky) return "Bulky";
        else return "Heavy";
    }
}