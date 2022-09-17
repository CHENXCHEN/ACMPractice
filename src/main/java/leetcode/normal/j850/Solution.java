package leetcode.normal.j850;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rectangle-area-ii/">850. 矩形面积 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    SegNode[] tree;
    ArrayList<Integer> bound;

    public int rectangleArea(int[][] rectangles) {
        // 离散化 y 坐标
        TreeSet<Integer> tSet = new TreeSet<>();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int[] rect : rectangles) {
            tSet.add(rect[1]);
            tSet.add(rect[3]);
        }
        bound = new ArrayList<>(tSet);
        int m = bound.size();
        tree = new SegNode[m << 2 | 1];
        // 我们对 bound[1]....bound[m-1] 建树，忽略 bound[0]，我们假定每个点代表的长度是它前面那个点和它组成的
        init(1, 1, m - 1);

        // 对 y 去重后，给每个 y 编号
        for (int i = 0; i < bound.size(); i++) {
            tMap.put(bound.get(i), i);
        }
        // 按照 x 坐标从小到大开始扫描
        ArrayList<int[]> seep = new ArrayList<>();
        for (int i = 0; i < rectangles.length; i++) {
            seep.add(new int[]{rectangles[i][0], i, 1});
            seep.add(new int[]{rectangles[i][2], i, -1});
        }
        seep.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });
        long ans = 0;
        int mod = 1000000000 + 7;
        for (int i = 0; i < seep.size(); i++) {
            int j = i;
            // 一次性处理完相同的横坐标
            while (j + 1 < seep.size() && seep.get(j + 1)[0] == seep.get(i)[0]) j++;
            if (j + 1 == seep.size()) break;
            for (int k = i; k <= j; k++) {
                int idx = seep.get(k)[1], diff = seep.get(k)[2];
                // 因为离散化的每个点代表的是和它左边的点构成的长度，因此这里要 +1
                int left = tMap.get(rectangles[idx][1]) + 1;
                int right = tMap.get(rectangles[idx][3]);
                update(1, 1, m - 1, left, right, diff);
            }
            // 计算当前 j & j+1 的面积，因为 [i,j] 都是相同的，那么减去等于 0
            ans += (long) tree[1].length * (seep.get(j + 1)[0] - seep.get(j)[0]);
            ans %= mod;
            i = j;
        }
        return (int) ans;
    }

    void init(int idx, int l, int r) {
        tree[idx] = new SegNode();
        if (l == r) {
            tree[idx].maxLength = bound.get(l) - bound.get(l - 1);
            return;
        }
        int mid = (l + r) >> 1;
        init(idx << 1, l, mid);
        init(idx << 1 | 1, mid + 1, r);
        tree[idx].maxLength = tree[idx << 1].maxLength + tree[idx << 1 | 1].maxLength;
    }

    void update(int idx, int l, int r, int ul, int ur, int diff) {
        if (l > ur || r < ul) return;
        if (ul <= l && r <= ur) {
            tree[idx].cover += diff;
            pushUp(idx, l, r);
            return;
        }
        int mid = (l + r) >> 1;
        update(idx << 1, l, mid, ul, ur, diff);
        update(idx << 1 | 1, mid + 1, r, ul, ur, diff);
        pushUp(idx, l, r);
    }

    void pushUp(int idx, int l, int r) {
        if (tree[idx].cover > 0) {
            tree[idx].length = tree[idx].maxLength;
        } else if (l == r) {
            tree[idx].length = 0;
        } else {
            tree[idx].length = tree[idx << 1].length + tree[idx << 1 | 1].length;
        }
    }
}

class SegNode {
    int maxLength = 0;
    int length = 0;
    int cover = 0;
}