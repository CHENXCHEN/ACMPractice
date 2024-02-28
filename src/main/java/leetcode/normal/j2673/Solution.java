package leetcode.normal.j2673;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/description/">2673. 使二叉树所有路径值相等的最小代价</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] cost, downSum;
    int n, maxDis;

    public int minIncrements(int n, int[] cost) {
        downSum = new int[n + 1];
        this.cost = cost;
        this.n = n;
        this.maxDis = calcDownSum(1);
        return solveMinIncrements(1, 0);
    }

    int solveMinIncrements(int root, int sum) {
        if (root > n) return 0;
        int res = maxDis - sum - downSum[root];
        sum += res + cost[root - 1];
        res += solveMinIncrements(leftChild(root), sum);
        res += solveMinIncrements(rightChild(root), sum);
        return res;
    }

    int calcDownSum(int root) {
        if (root > n) return 0;
        int leftSum = calcDownSum(leftChild(root));
        int rightSum = calcDownSum(rightChild(root));
        int mxSum = Math.max(leftSum, rightSum) + cost[root - 1];
        downSum[root] = mxSum;
        return mxSum;
    }

    int leftChild(int head) {
        return head << 1;
    }

    int rightChild(int head) {
        return head << 1 | 1;
    }
}