class Solution {
    class pair{
        int val;
        int freq;
        pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
    }
    public boolean isPossibleDivide(int[] nums, int k) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new pair(entry.getKey(),entry.getValue()));
}
        
        int prev=-1;
        while(pq.size()!=0){
            List<pair> ele=new ArrayList<>();
            int size=k;
            while(size-->0){
                if(pq.size()==0)return false;
              pair p=  pq.poll();
                
                if(prev!=-1){
                    if(p.val-prev!=1)return false;
                  
                }
                prev=p.val;
                
                int f=p.freq;
                f--;
                if(f!=0){
                    ele.add(new pair(p.val,f));
                }
                
            }
            prev=-1;
            for(int i=0;i<ele.size();i++){
                pq.add(ele.get(i));
            }
            
            ele.clear();
            
        }
        
        return true;
        
        
    }
}