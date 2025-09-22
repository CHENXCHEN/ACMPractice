package leetcode.normal.j1912;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-movie-rental-system/description/">1912. 设计电影租借系统</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MovieRentingSystem {

    static class Pair implements Comparable<Pair> {
        int key, value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return key == pair.key && value == pair.value;
        }

        @Override
        public int hashCode() {
            return (key << 16) ^ value;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.key != o.key) return this.key - o.key;
            return this.value - o.value;
        }
    }

    // movie -> (price, shop)
    TreeMap<Integer, TreeSet<Pair>> movies = new TreeMap<>();
    // (shop, movie) -> price
    TreeMap<Pair, Integer> prices = new TreeMap<>();
    // (price, shop, movie)
    TreeSet<int[]> rents = new TreeSet<>((x, y) -> {
        if (x[0] != y[0]) return x[0] - y[0];
        if (x[1] != y[1]) return x[1] - y[1];
        return x[2] - y[2];
    });

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            int shopId = entry[0];
            int movieId = entry[1];
            int price = entry[2];
            movies.computeIfAbsent(movieId, x -> new TreeSet<>()).add(new Pair(price, shopId));
            prices.put(new Pair(shopId, movieId), price);
        }
    }

    public List<Integer> search(int movie) {
        TreeSet<Pair> ss = movies.computeIfAbsent(movie, x -> new TreeSet<>());
        ArrayList<Integer> res = new ArrayList<>();
        Iterator<Pair> iterator = ss.iterator();
        for (int i = 0; i < 5 && iterator.hasNext(); i++) {
            res.add(iterator.next().value);
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = prices.get(new Pair(shop, movie));
        // 从店铺记录里移除
        movies.computeIfAbsent(movie, x -> new TreeSet<>()).remove(new Pair(price, shop));
        // 添加到借出记录里
        rents.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = prices.get(new Pair(shop, movie));
        // 添加到店铺记录里
        movies.computeIfAbsent(movie, x -> new TreeSet<>()).add(new Pair(price, shop));
        // 从借出记录删除
        rents.remove(new int[]{price, shop, movie});
    }

    public List<List<Integer>> report() {
        Iterator<int[]> iterator = rents.iterator();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 5 && iterator.hasNext(); i++) {
            int[] entry = iterator.next();
            List<Integer> row = new ArrayList<>();
            row.add(entry[1]);
            row.add(entry[2]);
            res.add(row);
        }
        return res;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */