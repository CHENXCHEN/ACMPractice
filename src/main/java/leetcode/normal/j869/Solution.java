package leetcode.normal.j869;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/reordered-power-of-2/
 * 869. 重新排序得到 2 的幂
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ArrayList<Integer> getBitCount(int n) {
        int[] ints = new int[10];
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - '0']++;
        }
        return Arrays.stream(ints).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public TreeSet<ArrayList<Integer>> buildSet(int n) {
        int maxN = (int)1e9;
        int res = 1;
        TreeSet<ArrayList<Integer>> tSet = new TreeSet<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) > o2.get(i)) return 1;
                    else if (o1.get(i) < o2.get(i)) return -1;
                }
                return 0;
            }
        });
        while (res <= maxN) {
            tSet.add(getBitCount(res));
            res <<= 1;
        }
        return tSet;
    }

    public boolean reorderedPowerOf2(int n) {
        return buildSet(n).contains(getBitCount(n));
    }
}
