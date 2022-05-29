package leetcode.week.j295.j6079;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/apply-discount-to-prices/
 * 6079. 价格减免
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int leftDiscount = 100 - discount;
        for (int i = 0; i < split.length; i++) {
            if (isPrice(split[i])) {
                String price = split[i].substring(1);
                double floatPrice = Double.parseDouble(price);
                double multiply = floatPrice *  leftDiscount / 100.0;
                String format = String.format("%.02f", multiply);
                sb.append('$').append(format);
            } else {
                sb.append(split[i]);
            }
            if (i != split.length - 1) sb.append(' ');
        }
        return sb.toString();
    }

    boolean isPrice(String word) {
        if (word.length() <= 1) return false;
        if (word.charAt(0) != '$') return false;
        String[] split = word.substring(1).split("\\.");
        if (split.length > 2) return false;
        for (String item : split) {
            for (int i = 0; i < item.length(); i++) {
                if (!Character.isDigit(item.charAt(i))) return false;
            }
        }
        return true;
    }
}