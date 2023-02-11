package leetcode.normal.j1604;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/">1604. 警告一小时内使用相同员工卡大于等于三次的人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Integer[] nums = new Integer[keyName.length];
        for (int i = 0; i < nums.length; i++) nums[i] = i;
        Arrays.sort(nums, (a, b) -> {
            if (!keyName[a].equals(keyName[b])) return keyName[a].compareTo(keyName[b]);
            return keyTime[a].compareTo(keyTime[b]);
        });
        ArrayList<String> ans = new ArrayList<>();
        String lastName = "", lastAns = "";
        int firstPos = 0;
        for (int j = 0; j < nums.length; j++) {
            int i = nums[j];
            if (lastAns.equals(keyName[i])) continue;
            if (!lastName.equals(keyName[i])) {
                lastName = keyName[i];
                firstPos = j;
            } else {
                while (firstPos < j && parseTime(keyTime[i]) - parseTime(keyTime[nums[firstPos]]) > 60)
                    ++firstPos;
                if (j - firstPos >= 2 && !lastAns.equals(keyName[i])) {
                    ans.add(keyName[i]);
                    lastAns = keyName[i];
                }
            }
        }
        ans.sort(String::compareTo);
        return ans;
    }

    int parseTime(String keyTime) {
        String[] split = keyTime.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}