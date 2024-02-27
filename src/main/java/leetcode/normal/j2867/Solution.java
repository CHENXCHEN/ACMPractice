package leetcode.normal.j2867;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-valid-paths-in-a-tree/description/">2867. 统计树中的合法路径数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;
    int[] cnt;

    int[] isPrime;

    public long countPaths(int n, int[][] _edges) {
        parent = new int[n + 1];
        cnt = new int[n + 1];
        isPrime = new int[n + 1];
        List<Integer>[] edges = new List[n + 1];
        initPrime();
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            edges[i] = new ArrayList<>();
        }
        for (int[] edge : _edges) {
            edges[edge[0]].add(edge[1]);
            edges[edge[1]].add(edge[0]);
            if (!checkPrime(edge[0]) && !checkPrime(edge[1])) {
                union(edge[0], edge[1]);
            }
        }
        for (int i = 1; i <= n; i++) cnt[find(i)]++;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (checkPrime(i)) {
                ArrayList<Integer> res = new ArrayList<>();
                for (Integer to : edges[i]) {
                    if (!checkPrime(to)) {
                        res.add(cnt[find(to)]);
                    }
                }
                int cur = 0;
                for (int j = 0; j < res.size(); j++) {
                    ans += (long) cur * res.get(j);
                    cur += res.get(j);
                }
                ans += cur;
//                System.out.println("prime: " + i + " res: " + res);
            }
        }
        return ans;
    }

    boolean checkPrime(int cur) {
        if (isPrime[cur] == 0) {
            isPrime[cur] = _isPrime(cur) ? 1 : 2;
        }
        return isPrime[cur] == 1;
    }

    void initPrime() {
        Arrays.fill(isPrime, 1);
        isPrime[1] = 2;
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = 2;
                }
            }
        }
    }

    boolean _isPrime(int cur) {
        if (cur == 1) return false;
        int sqrt = (int) Math.sqrt(cur);
        for (int i = 2; i <= sqrt; i++) {
            if (cur % i == 0) return false;
        }
        return true;
    }

    int find(int cur) {
        return cur == parent[cur] ? cur : (parent[cur] = find(parent[cur]));
    }

    void union(int p, int q) {
        int fp = find(p), fq = find(q);
        parent[fq] = fp;
    }
}