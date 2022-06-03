public class Solution {

    
    class pair{
        char ch;
        int freq;
        int time;
        pair(char ch,int freq,int time){
            this.ch=ch;
            this.freq=freq;
            this.time=time;
        }
    }
    public String reorganizeString(String s) {
        int n=s.length();

        int k=2;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.freq == b.freq)return a.time-b.time;
            return b.freq-a.freq;
        });
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
       Set<Character> keys= map.keySet();

        for(char ch:keys){
            pq.add(new pair(ch,map.get(ch),0));
        }


        StringBuilder sb=new StringBuilder();
        int time=1;
        while(pq.size()>0){
            List<pair> list=new ArrayList<>();
            if(pq.peek().freq>1 && pq.size()<(k))return "";
            int j=k;
            while(pq.size()>0 && j-->0){
                pair p=pq.poll();
                p.freq-=1;
                p.time=time;
                sb.append(p.ch);
                if(p.freq>0){
                    list.add(p);
                }
                time++;
            }
            for(int i=0;i<list.size();i++){
                pq.add(list.get(i));
            }
        }

        return new String(sb);

    }
}