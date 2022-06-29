package leetcode.normal.j535;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/
 * 535. TinyURL 的加密与解密
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Codec {
    ArrayList<String> arr = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        arr.add(longUrl);
        return String.valueOf(arr.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int number = Integer.parseInt(shortUrl);
        return arr.get(number);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));