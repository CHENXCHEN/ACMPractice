package leetcode.normal.j1797;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-authentication-manager/">1797. 设计一个验证系统</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class AuthenticationManager {
    int timeToLive;

    // 存储每个 token 生成的时间
    Map<String, Integer> tokenCurTime = new HashMap<>();
    // 存储生成时间对应的 token
    TreeMap<Integer, String> curTimeToken = new TreeMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    void expiredTokens(int currentTime) {
        // 找出要过期的那些键值
        SortedMap<Integer, String> needExpired = curTimeToken.subMap(Integer.MIN_VALUE, currentTime - timeToLive + 1);
        for (Map.Entry<Integer, String> entry : new ArrayList<>(needExpired.entrySet())) {
            // 如果 token 的生成时间改变了，就先不删除
            // 否则就删除该 token
            Integer tokenTime = tokenCurTime.get(entry.getValue());
            if (entry.getKey().equals(tokenTime)) {
                tokenCurTime.remove(entry.getValue());
            }
            // 删除该生成时间，因为已经过期了
            curTimeToken.remove(entry.getKey());
        }
    }

    public void generate(String tokenId, int currentTime) {
        tokenCurTime.put(tokenId, currentTime);
        curTimeToken.put(currentTime, tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        expiredTokens(currentTime);
        if (tokenCurTime.containsKey(tokenId)) {
            generate(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        expiredTokens(currentTime);
        return tokenCurTime.size();
    }
}