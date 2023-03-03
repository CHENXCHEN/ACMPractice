package leetcode.normal.j1487;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/making-file-names-unique/">1487. 保证文件名唯一</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        HashMap<String, Integer> tMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Integer idx = tMap.get(name);
            if (idx == null) {
                ans[i] = name;
                tMap.put(ans[i], 1);
            } else {
                String tmpName = suffix(name, idx);
                while (tMap.containsKey(tmpName)) {
                    tmpName = suffix(name, ++idx);
                }
                ans[i] = tmpName;
                tMap.put(name, idx);
                tMap.put(ans[i], 1);
            }
        }
        return ans;
    }

    String suffix(String name, Integer idx) {
        return name + "(" + idx + ")";
    }
}