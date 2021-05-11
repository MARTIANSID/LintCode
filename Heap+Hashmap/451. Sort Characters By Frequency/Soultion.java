class Solution {
    class pair{
            char ch;
            int freq;
            pair(char ch,int freq){
                    this.ch=ch;
                    this.freq=freq;
            }
    }
public String frequencySort(String s) {
    HashMap<Character,Integer> map=new HashMap<>();
        
       for(int i=0;i<s.length();i++){
               char ch=s.charAt(i);
               if(map.containsKey(ch)){
                       
                       int x=map.get(ch);
                            map.put(ch,x+1);
               }else{
                       map.put(ch,1);
               }
       }
      
        
StringBuilder sb = new StringBuilder();
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
                return b.freq-a.freq;
        });
           for (Map.Entry mapElement : map.entrySet()) {
                    
                   pq.add(new pair((char)mapElement.getKey(),(int)mapElement.getValue()));  
           }
        
        
        while(pq.size()!=0){
              pair p=  pq.poll();
                for(int i=0;i<p.freq;i++){
                       sb.append(p.ch);
                }
        }
        return sb.toString();
        
}
}