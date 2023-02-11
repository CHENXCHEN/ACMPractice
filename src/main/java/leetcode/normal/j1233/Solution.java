package leetcode.normal.j1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/">1233. 删除子文件夹</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String last = null;
        ArrayList<String> ans = new ArrayList<>();
        for (String fold : folder) {
            if (last == null) {
                last = fold + "/";
                ans.add(fold);
            } else if (!fold.startsWith(last)) {
                last = fold + "/";
                ans.add(fold);
            }
        }
        return ans;
    }
}