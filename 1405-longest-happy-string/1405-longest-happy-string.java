class Solution {

    class pair {
        char ch;
        int freq;

        pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public String toString() {
            return ch + "" + freq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (x, y) -> {
                return y.freq - x.freq;
            }
        );

        if (a != 0) pq.add(new pair('a', a));
        if (b != 0) pq.add(new pair('b', b));
        if (c != 0) pq.add(new pair('c', c));
        StringBuilder sb = new StringBuilder();
        
           
    
        
        while (pq.size() > 0) {
            pair p = pq.poll();
            p.freq -= 1;
            sb.append(p.ch);
            if (p.freq > 0) {
                p.freq -= 1;
                sb.append(p.ch);
            }
            if (pq.size() == 0) break;
            pair p1 = pq.poll();
            p1.freq-=1;
            sb.append(p1.ch);
            if (p1.freq > 0 && p.freq<=p1.freq) {
                p1.freq -= 1;
                sb.append(p1.ch);
            }
            if (p.freq > 0) pq.add(p);
            if (p1.freq > 0) pq.add(p1);
          
        }
        return new String(sb);
    }
}
