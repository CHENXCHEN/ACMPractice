package leetcode.normal.j591;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/tag-validator/
 * 591. 标签验证器
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public Integer findTagNamePos(String code, Integer pos) {
        while (pos < code.length() && code.charAt(pos) != '>') pos++;
        return pos;
    }

    public Integer findCDataPos(String code, Integer pos) {
        while (pos < code.length() && !code.startsWith("]]>", pos)) pos++;
        return pos;
    }

    public Boolean isTagNameValid(String tagName) {
        if (tagName.length() <= 0 || tagName.length() > 9) return false;
        for (int i = 0; i < tagName.length(); i++) {
            char ch = tagName.charAt(i);
            if (!(ch >= 'A' && ch <= 'Z')) return false;
        }
        return true;
    }

    public boolean isValid(String code) {
        if (code.length() <= 2 || code.charAt(0) != '<') return false;
        ArrayDeque<String> stack = new ArrayDeque<>();
        int pos = 0;
        while (pos < code.length()) {
            if (code.startsWith("<![CDATA[", pos)) {
                if (stack.isEmpty()) return false;
                Integer cDataPos = findCDataPos(code, pos);
                if (code.startsWith("]]>", cDataPos)) {
                    pos = cDataPos + 3;
                } else {
                    return false;
                }
            } else if (code.startsWith("</", pos)) {
                Integer tagNamePos = findTagNamePos(code, pos);
                if (code.startsWith(">", tagNamePos)) {
                    String tagName = code.substring(pos + 2, tagNamePos);
//                    print("close tag: " + tagName);
                    if (isTagNameValid(tagName)) {
                        if (stack.isEmpty()) return false;
                        String needTagName = stack.pop();
                        pos = tagNamePos + 1;
                        if (!needTagName.equals(tagName) || (stack.isEmpty() && pos < code.length())) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (code.startsWith("<", pos)) {
                Integer tagNamePos = findTagNamePos(code, pos);
                if (code.startsWith(">", tagNamePos)) {
                    String tagName = code.substring(pos + 1, tagNamePos);
//                    print("open tag: " + tagName);
                    if (isTagNameValid(tagName)) {
                        stack.push(tagName);
                        pos = tagNamePos + 1;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else pos ++;
        }
        return stack.isEmpty();
    }

    void print(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
//        System.out.println(solution.isValid("<DIV></DIV><DIV></DIV>"));
        System.out.println(solution.isValid("<A>  <B> </A>   </B"));
        System.out.println(solution.isValid("<DIV>This is the first line <![CDATA[<div>]]><DIV>"));
    }
}