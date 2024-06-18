package leetcode.normal.j2288;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/apply-discount-to-prices/description/">2288. 价格减免</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) sb.append(' ');
            if (words[i].charAt(0) == '$') {
                String num = words[i].substring(1);
                if (isDigit(num)) {
                    double v = Double.parseDouble(num);
                    v -= v * (discount / 100.0);
                    String format = String.format("%.2f", v);
                    sb.append("$").append(format);
                } else sb.append(words[i]);
            } else
                sb.append(words[i]);
        }
        return sb.toString();
    }

    boolean isDigit(String str) {
        if (str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
}