package leetcode.normal.j1125;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-sufficient-team/">1125. 最小的必要团队</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> hMap = new HashMap<>();
        for (String reqSkill : req_skills) {
            hMap.put(reqSkill, hMap.size());
        }
        int tot = 1 << req_skills.length;
        int[] dp = new int[tot];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] peopleMark = new int[people.size()];
        int[] preMask = new int[tot], maskNum = new int[tot];
        for (int i = 0; i < people.size(); i++) {
            int cur = 0;
            for (String s : people.get(i)) {
                cur |= 1 << hMap.get(s);
            }
            peopleMark[i] = cur;
            for (int j = 0; j < tot; j++) {
                if (dp[j] != Integer.MAX_VALUE && dp[j] + 1 < dp[j | cur]) {
                    dp[j | cur] = dp[j] + 1;
                    preMask[j | cur] = j;
                    maskNum[j | cur] = i;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int cur = tot - 1;
        while (cur != 0) {
            ans.add(maskNum[cur]);
            cur = preMask[cur];
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] reqSkills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = new ArrayList<>();
        people.add(Arrays.asList("java"));
        people.add(Arrays.asList("nodejs"));
        people.add(Arrays.asList("nodejs", "reactjs"));
        int[] ints = solution.smallestSufficientTeam(reqSkills, people);
        System.out.println(Arrays.toString(ints));
    }
}