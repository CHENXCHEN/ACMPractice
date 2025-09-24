package leetcode.normal.j166;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/fraction-to-recurring-decimal/description/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = (long) numerator;
        long den = (long) denominator;
        if (num % den == 0) {
            return String.valueOf(num / den);
        }

        StringBuilder sb = new StringBuilder();
        if ((num < 0) ^ (den < 0)) {
            sb.append('-');
        }
        num = Math.abs(num);
        den = Math.abs(den);
        long integerPart = num / den;
        sb.append(integerPart);
        sb.append('.');
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainderIdxMap = new HashMap<>();
        long remainder = num % den;
        int idx = 0;
        // 模拟除法的逻辑
        while (remainder != 0 && !remainderIdxMap.containsKey(remainder)) {
            remainderIdxMap.put(remainder, idx);
            remainder *= 10;
            fractionPart.append(remainder / den);
            remainder %= den;
            idx++;
        }
        // 如果有循环节
        if (remainder != 0) {
            int insertIdx = remainderIdxMap.get(remainder);
            fractionPart.insert(insertIdx, '(');
            fractionPart.append(')');
        }
        sb.append(fractionPart);

        return sb.toString();
    }
}