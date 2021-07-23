class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq=new int[26];
        
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{return b-a;});
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0)pq.add(freq[i]);
        }
        int ans=0;
        
        while(pq.size()!=0){
            List<Integer>  tasksUnderProcess=new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(pq.size()!=0)
                tasksUnderProcess.add(pq.poll());
            }
            
            
          
            for(int i=0;i<tasksUnderProcess.size();i++){
               
                if(tasksUnderProcess.get(i)-1!=0){
                    pq.add(tasksUnderProcess.get(i)-1);
                   
                }
                
               
            }

            if(pq.size()!=0){
                ans+=n+1;
            }else{
                ans+=  tasksUnderProcess.size();
            }
            
            
            
        }
                
        return ans;
        
        
    }
}


