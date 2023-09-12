package leetcode.normal.j1462;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/course-schedule-iv/description/">1462. 课程表 IV</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[][] edges = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            edges[prerequisite[0]][prerequisite[1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) edges[i][i] = 1;
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (edges[i][k] == 1 && edges[k][j] == 1) {
                        edges[i][j] = 1;
                    }
                }
            }
        }
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(edges[query[0]][query[1]] == 1);
        }
        return ans;
    }
}