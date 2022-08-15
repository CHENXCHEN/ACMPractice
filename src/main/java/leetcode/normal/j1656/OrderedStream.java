package leetcode.normal.j1656;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-an-ordered-stream/">1656. 设计有序流</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class OrderedStream {
    String[] list;
    int ptr;

    public OrderedStream(int n) {
        list = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        ArrayList<String> ans = new ArrayList<>();
        list[idKey - 1] = value;
        if (idKey - 1 == ptr) {
            for (int i = ptr; i < list.length; i++, ptr++) {
                if (list[i] == null) break;
                ans.add(list[i]);
            }
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */