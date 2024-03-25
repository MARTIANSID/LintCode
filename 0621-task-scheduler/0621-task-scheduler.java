class Solution {

    class Pair {
        int freq;
        int time;

        Pair(int freq, int time) {
            this.freq = freq;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int size = tasks.length;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.time == b.time) {
                    return b.freq - a.freq;
                }
                return a.time - b.time;
            }
        );

        Set<Character> set = map.keySet();

        for (char key : set) {
            pq.add(new Pair(map.get(key), 0));
        }

        int time = 0;

        while (pq.size() != 0) {
            //             Pair p = pq.poll();

            //             if (p.time >= time) {
            //                 time += p.time - time + 1;
            //             } else {
            //                 time += 1;
            //             }

            //             p.time = time + n;

            List<Pair> arr = new ArrayList<>();

            int f = 0;

            while (pq.size() > 0 && pq.peek().time <= time) {
                f = Math.max(f, pq.peek().freq);
                arr.add(pq.poll());
            }

            boolean flag = false;
            
            for (Pair p : arr) {
                int freq = p.freq;
                int t = p.time;

                if (freq == f && !flag) {
                    freq--;
                    t = time + 1 + n;
                    if(freq > 0){
                        pq.add(new Pair(freq,t));
                    }
                    
                    flag = true;
                    
                } else {
                    pq.add(new Pair(freq,time));
                }
            }
            
            if(arr.size()>0){
                time+=1;
            } else{
                Pair p = pq.poll();
                time += p.time - time + 1;
                
                if((p.freq-1)>0){
                    pq.add(new Pair(p.freq-1,time+n));
                }
            }
        }
        return time;
    }
}
// A -> time = 1 , A.time = 2
// C -> time = 2
// B -> time = 3, B.time = 5
