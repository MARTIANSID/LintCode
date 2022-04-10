class MyHashMap {

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node>[] buckets;
    int size = 900;

    public MyHashMap() {
        this.buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucket(int key) {
        
        return key % size;
    }

    private int getIndexInBucket(int bucket, int key) {
        LinkedList<Node> nodes = buckets[bucket];
        int index = 0;
        for (Node node : nodes) {
            if (node.key == key) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(bucket, key);
        if (indexInBucket == -1) {
            buckets[bucket].add(new Node(key, value));
        } else {
            buckets[bucket].get(indexInBucket).value = value;
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(bucket, key);
        
        if(indexInBucket == -1)return -1;
        
        return buckets[bucket].get(indexInBucket).value;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(bucket, key);
        
        if(indexInBucket == -1)return;
        
        buckets[bucket].remove(indexInBucket);
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
