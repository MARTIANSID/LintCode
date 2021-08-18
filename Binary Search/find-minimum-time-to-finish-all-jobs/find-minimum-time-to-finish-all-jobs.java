class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
                //binary search + dp
        
        // Arrays.sort(jobs);
        int low=jobs[0],hi=(int)1e9;
        
        while(low<=hi){
            
            int mid=(low+hi)/2;
            int[] workers=new int[k];
            if(dfs(jobs,0,workers,mid))hi=mid-1;
            else low=mid+1;
            
        }
        
        return low;
        
    }
    public boolean dfs(int[] jobs,int index,int[] workers,int val){
        
        if(index==jobs.length)return true;
        
        for(int i=0;i<workers.length;i++){
            if(workers[i]+jobs[index]<=val)
            {
                workers[i]+=jobs[index];
               boolean possible= dfs(jobs,index+1,workers,val);
                if(possible)return true;
                workers[i]-=jobs[index];

            }
            if(workers[i]==0)break;
        }
        
        return false;
        
    }   
    
}

// [1,2,4,7,8] 


