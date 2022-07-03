package leetcode.normal.j556;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/next-greater-element-iii/">556. 下一个更大元素 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int nextGreaterElement(int n) {
        byte[] bytes = String.valueOf(n).getBytes();
        // 从右往左找到第一个比右边小的位置 i, 在这个位置右边，必然是非升序的
        int i = bytes.length - 2;
        while (i >= 0 && bytes[i] >= bytes[i + 1]) i--;
        if (i < 0) return -1;
        // 从右边找到第一个大于 bytes[i] 的位置 j
        int j = bytes.length - 1;
        while (bytes[i] >= bytes[j]) j--;
        // bytes[i] < bytes[j]，因为 bytes[i] >= bytes[j-1]，因此交换过去后，i 的右边依然保持降序
        swap(bytes, i, j);
        reverse(bytes, i + 1, bytes.length - 1);
        try {
            return Integer.parseInt(new String(bytes));
        } catch (Exception e) {
            return -1;
        }
    }

    void swap(byte[] bytes, int i, int j) {
        byte tmp = bytes[i];
        bytes[i] = bytes[j];
        bytes[j] = tmp;
    }

    void reverse(byte[] bytes, int left, int right) {
        while (left < right) {
            swap(bytes, left, right);
            left++;
            right--;
        }
    }
}