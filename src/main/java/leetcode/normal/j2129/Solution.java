package leetcode.normal.j2129;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/capitalize-the-title/description/">2129. 将标题首字母大写</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String capitalizeTitle(String title) {
        String[] split = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i != 0) sb.append(' ');
            if (split[i].length() <= 2) {
                for (int j = 0; j < split[i].length(); j++) sb.append(Character.toLowerCase(split[i].charAt(j)));
            } else {
                sb.append(Character.toUpperCase(split[i].charAt(0)));
                for (int j = 1; j < split[i].length(); j++) sb.append(Character.toLowerCase(split[i].charAt(j)));
            }
        }
        return sb.toString();
    }
}