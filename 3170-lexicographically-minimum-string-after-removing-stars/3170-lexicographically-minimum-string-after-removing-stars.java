class Solution {
    
    class pair {
        int index;
        int code;
        
        pair(int index, int code) {
            this.index = index;
            this.code = code;
        }
    }
    
    public String clearStars(String s) {
        int n = s.length();
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            
            if(a.code == b.code) {
                return b.index - a.index;
            }
            return a.code - b.code;
        });
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(ch == '*') {
                if(pq.size() > 0) {
                    pq.poll();
                }
            } else {
                pq.add(new pair(i,ch-'a'));
            }
        }
        
        List<pair> arr = new ArrayList<>();
        
        while(pq.size() > 0) {
            arr.add(pq.poll());
        }
        
        Collections.sort(arr,(a,b)->{
            return a.index - b.index;
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.size(); i++) {
            sb.append((char)(arr.get(i).code+'a')+"");
        }
        return sb.toString();
        
    }
}