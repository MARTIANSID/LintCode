class Solution {
        class pair{
                int no;
                int frequency;
                pair(int no,int frequency){
                        this.no=no ;
                        this.frequency=frequency;
                }
        }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<pair> que=new PriorityQueue<>((a,b)->{
              return  a.frequency-b.frequency;
        });
          
            
            HashMap<Integer,Integer> map=new HashMap<>();
            
                  for(int ele:nums){
                    if(map.containsKey(ele)){
                            int x=map.get(ele);
                            map.put(ele,x+1);
                    }else{
                            map.put(ele,1);
                    }
            }
            
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	    que.add(new pair(entry.getKey(),entry.getValue()));
                if(que.size()>k)que.poll();
}
            int[] ans=new int[k];
            int m=0;
            while(k-->0){
                 ans[m]=que.poll().no;
                         m++;
            }
            return ans;
            
    
}
}