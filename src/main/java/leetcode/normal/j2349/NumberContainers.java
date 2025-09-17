package leetcode.normal.j2349;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-a-number-container-system/description/">2349. 设计数字容器系统</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class NumberContainers {
    TreeMap<Integer, Integer> nums = new TreeMap<>();
    TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        Integer prevNum = nums.get(index);
        if (prevNum != null) {
            map.get(prevNum).remove(index);
        }
        nums.put(index, number);
        map.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> ss = map.get(number);
        if (ss == null || ss.isEmpty()) return -1;
        return ss.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */