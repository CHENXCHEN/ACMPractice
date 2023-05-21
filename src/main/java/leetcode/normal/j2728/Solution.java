package leetcode.normal.j2728;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/o8SXZn/">LCP 33. 蓄水</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public int storeWater(int[] bucket, int[] vat) {
        // 只需要考虑先增加桶的大小，再统一蓄水，这样是最大的，因此每次增加蓄水次数最大的桶就可以降低蓄水次数
        // 最多不会超过 max(vat[i]) + 1 次
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> needTimes(y) - needTimes(x));
        int n = bucket.length;
        int ans = Integer.MAX_VALUE, opTimes = 0;
        for (int i = 0; i < n; i++) {
            Node e = new Node(bucket[i], vat[i]);
            pq.add(e);
        }
        while (!pq.isEmpty() && opTimes < ans) {
            Node poll = pq.poll();
            int nodeNeed = needTimes(poll);
            int need = nodeNeed + opTimes;
            if (nodeNeed != Integer.MAX_VALUE && need <= ans) {
                ans = need;
            }
            poll.bucket++;
            pq.add(poll);
            opTimes++;
        }
        return ans;
    }

    int needTimes(Node node) {
        if (node.vat == 0) return 0;
        if (node.bucket == 0) return Integer.MAX_VALUE;
        return node.vat / node.bucket + (node.vat % node.bucket == 0 ? 0 : 1);
    }

    static class Node {
        int bucket, vat;

        Node(int _bucket, int _vat) {
            bucket = _bucket;
            vat = _vat;
        }
    }
}