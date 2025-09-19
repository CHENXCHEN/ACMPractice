package leetcode.normal.j3484;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-spreadsheet/description/">3484. 设计电子表格</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Spreadsheet {
    int[][] values;

    public Spreadsheet(int rows) {
        values = new int[rows + 1][26];
    }

    public void setCell(String cell, int value) {
        int[] ss = parseCell(cell);
        int row = ss[0], col = ss[1];
        values[row][col] = value;
    }

    public void resetCell(String cell) {
        int[] ss = parseCell(cell);
        int row = ss[0], col = ss[1];
        values[row][col] = 0;
    }

    public int getCellValue(String cell) {
        int[] ss = parseCell(cell);
        int row = ss[0], col = ss[1];
        return values[row][col];
    }

    public int getValue(String formula) {
        String[] split = formula.substring(1).split("\\+");
        System.out.println(Arrays.toString(split));
        int v1, v2;
        if (!Character.isDigit(split[0].charAt(0))) {
            v1 = getCellValue(split[0]);
        } else {
            v1 = Integer.parseInt(split[0]);
        }
        if (!Character.isDigit(split[1].charAt(0))) {
            v2 = getCellValue(split[1]);
        } else {
            v2 = Integer.parseInt(split[1]);
        }
        return v1 + v2;
    }

    int[] parseCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        return new int[]{row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */