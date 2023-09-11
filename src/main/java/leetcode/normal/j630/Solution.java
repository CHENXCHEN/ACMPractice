package leetcode.normal.j630;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/course-schedule-iii/description/">630. 课程表 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int tot = 0;
        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (tot + ti <= di) {
                tot += ti;
                pq.add(ti);
            } else if (!pq.isEmpty() && pq.peek() > ti) {
                tot -= pq.poll() - ti;
                pq.add(ti);
            }
        }
        return pq.size();
    }
}