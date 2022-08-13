package leetcode.normal.j768;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/">768. 最多能完成排序的块 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int maxChunksToSorted(int[] arr) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int num : arr) {
            if (deque.isEmpty() || deque.peek() <= num) {
                deque.push(num);
            } else {
                int mx = deque.pop();
                while (!deque.isEmpty() && deque.peek() > num) deque.pop();
                deque.push(mx);
            }
        }
        return deque.size();
    }
}
