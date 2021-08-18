class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obs) {
        // nlogn  lis using binary search
        int n=obs.length;
        List<Integer> temp=new ArrayList<>();
        int[] ans=new int[n];
        temp.add(obs[0]);
        ans[0]=1;
        for(int i=1;i<n;i++){
           int up= upper(obs,obs[i],temp);
         

           if(up==temp.size()){
               temp.add(obs[i]);
           }else{
              
               temp.set(up,obs[i]);
           }
            ans[i]=up+1;
            
        }
        return ans;
        
    }
    
    public int upper(int[] obs,int val,List<Integer> temp){
                       
        int lo=0,hi=temp.size()-1;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
            
            if(val>=temp.get(mid))lo=mid+1;
            else hi=mid-1;
        }        
          
        return lo;
            
    }
}














