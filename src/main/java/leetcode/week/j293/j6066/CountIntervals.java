package leetcode.week.j293.j6066;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/count-integers-in-intervals/submissions/
 * 6066. 统计区间中的整数数目
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class CountIntervals {

    static class Line {
        int left, right;

        Line(int _left, int _right) {
            left = _left;
            right = _right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getLen() {
            return right - left + 1;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    TreeSet<Line> tSet;
    int ans;

    public CountIntervals() {
        tSet = new TreeSet<>((x, y) -> {
            if (x.getLeft() != y.getLeft()) return x.getLeft() - y.getLeft();
            return x.getRight() - y.getRight();
        });
        ans = 0;
    }

    boolean shouldMerge(Line l1, Line l2) {
        return (l1.left <= l2.left && l2.left <= l1.right) || (l1.left <= l2.right && l2.right <= l1.right) ||
                (l1.left <= l2.left && l2.right <= l1.right) || (l2.left <= l1.left && l1.right <= l2.right);
    }

    Line mergeTwoLine(Line l1, Line l2) {
        return new Line(Math.min(l1.left, l2.left), Math.max(l1.right, l2.right));
    }

    Line getMergeLineLeft(Line nLine) {
        // 1. 找到 preLeft <= left && left <= preRight 的所有区间，尝试合并
        // 那么需要找到一个左端点小于等于 left 的线段
        Line needMerge = tSet.floor(new Line(nLine.left, nLine.left));
        if (needMerge == null || !shouldMerge(needMerge, nLine)) return null;
        Line merged = mergeTwoLine(needMerge, nLine);
        tSet.remove(needMerge);
        ans -= needMerge.getLen();
        return merged;
    }

    Line getMergeLineRight(Line nLine) {
        // 2. 找到 preLeft <= right && right <= preRight 的所有区间，尝试合并
        // 那么需要找到一个左端点大于等于 left 的线段
        Line needMerge = tSet.ceiling(new Line(nLine.left, nLine.left));
        if (needMerge == null || !shouldMerge(needMerge, nLine)) return null;
        Line merged = mergeTwoLine(needMerge, nLine);
        tSet.remove(needMerge);
        ans -= needMerge.getLen();
        return merged;
    }

    Line getMergeLine(Line nLine) {
        Line mergeLineLeft = getMergeLineLeft(nLine);
        if (mergeLineLeft != null) return mergeLineLeft;
        return getMergeLineRight(nLine);
    }

    public void add(int left, int right) {
        Line preLine = new Line(left, right);
//        System.out.println("\n\nadd " + preLine);
        Line mergeLine = getMergeLine(preLine);
        while (mergeLine != null) {
            preLine = mergeLine;
//            System.out.println("get merge line: " + mergeLine);
            mergeLine = getMergeLine(mergeLine);
        }
        ans += preLine.getLen();
        tSet.add(preLine);
//        print();
    }

    void print() {
        System.out.println("**********");
        tSet.forEach(System.out::println);
    }

    public int count() {
        return ans;
    }

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();
        countIntervals.add(2, 3);
        System.out.println(countIntervals.count());
        countIntervals.add(7, 10);
        System.out.println(countIntervals.count());
        countIntervals.add(5, 8);
//        countIntervals.add(39, 44);
//        countIntervals.add(13, 49);
        System.out.println(countIntervals.count());
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */