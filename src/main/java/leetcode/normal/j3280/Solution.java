package leetcode.normal.j3280;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/convert-date-to-binary/description/">3280. 将日期转换为二进制表示</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String convertDateToBinary(String date) {
        String[] split = date.split("-");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i != 0) sb.append('-');
            sb.append(Integer.toBinaryString(Integer.parseInt(split[i])));
        }
        return sb.toString();
    }


}