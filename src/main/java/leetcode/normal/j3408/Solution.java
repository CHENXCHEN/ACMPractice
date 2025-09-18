package leetcode.normal.j3408;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-task-manager/description/">3408. 设计任务管理器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class TaskManager {

    TreeMap<Integer, Integer> taskUser = new TreeMap<>();
    TreeMap<Integer, Integer> taskPriority = new TreeMap<>();
    TreeMap<Integer, TreeSet<Integer>> priorityTasks = new TreeMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            Integer userId = task.get(0);
            Integer taskId = task.get(1);
            Integer priority = task.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskUser.put(taskId, userId);
        taskPriority.put(taskId, priority);
        priorityTasks.computeIfAbsent(priority, k -> new TreeSet<>()).add(taskId);
    }

    public void edit(int taskId, int newPriority) {
        Integer userId = taskUser.get(taskId);
        rmv(taskId);
        add(userId, taskId, newPriority);
    }

    public void rmv(int taskId) {
        Integer priority = taskPriority.get(taskId);
        priorityTasks.computeIfAbsent(priority, k -> new TreeSet<>()).remove(taskId);
        if (priorityTasks.get(priority).isEmpty()) {
            priorityTasks.remove(priority);
        }
        taskUser.remove(taskId);
        taskPriority.remove(taskId);
    }

    public int execTop() {
        Map.Entry<Integer, TreeSet<Integer>> lastPriority = priorityTasks.lastEntry();
        if (lastPriority == null) return -1;
        Integer taskId = lastPriority.getValue().last();
        int userId = taskUser.get(taskId);
        rmv(taskId);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */