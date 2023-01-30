
import java.util.*;

class LFUCache {
    int capacity;
    int minFrequency;
    int cap;

    class pair {
        int counter;
        int val;

        pair(int counter, int val) {
            this.counter = counter;
            this.val = val;

        }
    }

    HashMap<Integer, LinkedHashSet<Integer>> freq;
    HashMap<Integer, pair> map;

    public LFUCache(int capacity) {
        this.cap=capacity;
        this.capacity = capacity;
        this.freq = new HashMap<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        pair p = map.get(key);
        int counter = p.counter, val = p.val;
        freq.get(counter).remove(key);
        if (freq.get(counter).size() == 0) {
            freq.remove(counter);
            if (minFrequency == counter) {
                minFrequency++;
            }
        }
        freq.putIfAbsent(counter + 1, new LinkedHashSet<>());
        freq.get(counter + 1).add(key);
        map.put(key, new pair(counter + 1, val));
        return val;
    }

    public void put(int key, int value) {
        if(cap == 0)return;

        if (!map.containsKey(key)) {
            capacity--;
            map.put(key, new pair(1, value));
        } else {
            pair p = map.get(key);
            map.put(key, new pair(p.counter, value));
            get(key);
            return;
        }

        if(capacity==-1){
            int keyToBeRemoved=freq.get(minFrequency).iterator().next();
            freq.get(minFrequency).remove(keyToBeRemoved);
            if(freq.get(minFrequency).size()==0)freq.remove(minFrequency);
            map.remove(keyToBeRemoved);
            capacity++;
        }
        minFrequency=1;
        freq.putIfAbsent(1, new LinkedHashSet<>());
        freq.get(1).add(key);
        
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */