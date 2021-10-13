package leetcode.normal.j412;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/fizz-buzz/
 * 412. Fizz Buzz
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int mod3 = i % 3;
            int mod5 = i % 5;
            if (mod3 == 0 && mod5 == 0) {
                arrayList.add("FizzBuzz");
            } else if (mod3 == 0) {
                arrayList.add("Fizz");
            } else if (mod5 == 0) {
                arrayList.add("Buzz");
            } else {
                arrayList.add(String.valueOf(i));
            }
        }
        return arrayList;
    }
}