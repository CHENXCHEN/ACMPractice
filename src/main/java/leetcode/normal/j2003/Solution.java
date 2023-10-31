package leetcode.normal.j2003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/description/">2003. 每棵子树内缺失的最小基因值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] ans;
    Set<Integer>[] genSet;
    ArrayList<Integer>[] edges;
    int n;
    int[] nums;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        this.nums = nums;
        n = parents.length;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            edges[parents[i]].add(i);
        }
        ans = new int[n];
        Arrays.fill(ans, 1);
        genSet = new Set[n];
        for (int i = 0; i < n; i++) genSet[i] = new HashSet<>();
        dfs(0);
        return ans;
    }

    int dfs(int cur) {
        genSet[cur].add(nums[cur]);
        for (Integer next : edges[cur]) {
            ans[cur] = Math.max(ans[cur], dfs(next));
            if (genSet[cur].size() < genSet[next].size()) {
                Set<Integer> temp = genSet[next];
                genSet[next] = genSet[cur];
                genSet[cur] = temp;
            }
            genSet[cur].addAll(genSet[next]);
        }
        while (genSet[cur].contains(ans[cur])) {
            ans[cur]++;
        }
        return ans[cur];
    }
}