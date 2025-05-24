package leetcode.normal.j353;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-snake-game/description/">353. 贪吃蛇</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class SnakeGame {
    ArrayDeque<int[]> snake = new ArrayDeque<>();
    int rows, cols;
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}, food;
    int[] dirIdx = new int[26];
    int foodIdx = 0;
    Set<Integer> snakeBody = new HashSet<>();

    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.cols = width;
        this.rows = height;
        snake.push(new int[]{0, 0});
        snakeBody.add(0);
        dirIdx['R' - 'A'] = 3;
        dirIdx['L' - 'A'] = 2;
        dirIdx['U' - 'A'] = 0;
        dirIdx['D' - 'A'] = 1;
    }

    int getFoodMark() {
        int pos = -1;
        if (foodIdx < food.length) {
            pos = food[foodIdx][0] * cols + food[foodIdx][1];
        }
        return pos;
    }

    void incrFood() {
        ++foodIdx;
    }

    public int move(String _direction) {
        int[] dir = direction[dirIdx[_direction.charAt(0) - 'A']];
        int[] pos = snake.peek();
        int x = pos[0] + dir[0], y = pos[1] + dir[1];
        if (x < 0 || x >= rows || y < 0 || y >= cols) return -1;
        int nextMark = x * cols + y;
        snake.push(new int[]{x, y});
        if (getFoodMark() == nextMark) {
            incrFood();
        } else {
            int[] last = snake.pollLast();
            snakeBody.remove(last[0] * cols + last[1]);
        }
        if (snakeBody.contains(nextMark)) return -1;
        snakeBody.add(nextMark);
        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */