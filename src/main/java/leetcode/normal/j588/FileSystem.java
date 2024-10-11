package leetcode.normal.j588;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-in-memory-file-system/description/">588. 设计内存文件系统</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FileSystem {
    TreeMap<String, TreeSet<String>> paths;
    TreeMap<String, String> fileContents;

    public FileSystem() {
        paths = new TreeMap<>();
        fileContents = new TreeMap<>();
    }

    public List<String> ls(String path) {
        ArrayList<String> ans = new ArrayList<>();
        if (fileContents.containsKey(path)) {
            String[] split = path.split("/");
            ans.add(split[split.length - 1]);
        } else {
            path = Objects.equals(path, "/") ? "" : path;
            TreeSet<String> list = paths.get(path);
//            System.out.println("list path: " + path + " list: " + list);
            if (list != null) ans.addAll(list);
        }
        return ans;
    }

    public void mkdir(String path) {
        StringBuilder sb = new StringBuilder();
        for (String split : path.split("/")) {
            if (!Objects.equals(split, "")) {
                String parent = sb.toString();
                sb.append('/');
                sb.append(split);
                paths.compute(parent, (kk, vv) -> vv == null ? new TreeSet<>() : vv).add(split);
//                System.out.println("parent: " + parent + " current: " + split);
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        mkdir(filePath);
        fileContents.compute(filePath, (kk, vv) -> vv == null ? content : vv + content);
    }

    public String readContentFromFile(String filePath) {
        return fileContents.get(filePath);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */