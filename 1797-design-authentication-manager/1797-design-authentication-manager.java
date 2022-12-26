import java.util.*;

class AuthenticationManager {
    int timeToLive;
    HashMap<String, Integer> map;
    TreeSet<Integer> set;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<>();
        this.set = new TreeSet<>();
    }

    public void generate(String tokenId, int currentTime) {
        int time = currentTime + timeToLive;
        map.put(tokenId, time);
        set.add(time);
    }

    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)) return;
        int expiryTime = map.get(tokenId);
        if (expiryTime <= currentTime) return;
        int time = currentTime + timeToLive;
        map.put(tokenId, time);
        set.remove(expiryTime);
        set.add(time);
    }

    public int countUnexpiredTokens(int currentTime) {
        Iterator<Integer> itr = set.iterator();
        List<Integer> arr = new ArrayList<>();
        while (itr.hasNext()) {
            arr.add(itr.next());
        }
        int lo = 0, hi = arr.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) > currentTime) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return arr.size() - lo;
    }
}
