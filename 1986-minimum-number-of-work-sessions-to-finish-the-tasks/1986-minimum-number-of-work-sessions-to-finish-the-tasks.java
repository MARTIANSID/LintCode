class Solution {
    int min=(int)1e9;
    public int minSessions(int[] tasks, int sessionTime) {
        int n=tasks.length;
        List<Integer> work=new ArrayList<>();
        
        solve(tasks,work,0,sessionTime);
        
        return min;
        
    }
    
    public void solve(int[] tasks,List<Integer> work,int index,int sessionTime){
        
        if(index==tasks.length){
        
            
            min=Math.min(min,work.size());
            
            return;
        }
        
        if(work.size()>=min)return;
        
        for(int i=0;i<work.size();i++){
            if(work.get(i)+tasks[index]<=sessionTime){
                work.set(i,work.get(i)+tasks[index]);
                solve(tasks,work,index+1,sessionTime);
                 work.set(i,work.get(i)-tasks[index]);
            }
            
        }
        if(work.size()+1>=min||work.size()>=min)return;
        
        work.add(tasks[index]);
        
    
        
        solve(tasks,work,index+1,sessionTime);
        work.remove(work.size()-1);
        
        
    }
    
}