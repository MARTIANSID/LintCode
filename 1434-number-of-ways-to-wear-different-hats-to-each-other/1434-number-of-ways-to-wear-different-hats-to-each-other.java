class Solution {
    
    Long[][] dp;
    int mod=(int)1e9+7;
    public boolean check(int mask,int size){
        
        for(int i=size-1;i>=0;i--){
            int x=1<<i;
            int bit=(mask&x)==0?0:1;
            if(bit == 0)return false;
        }
        return true;
    }
    
    public int numberWays(List<List<Integer>> hats) {
        HashSet<Integer> set=new HashSet<>();
        
        HashMap<Integer,HashSet<Integer>> personToHats=new HashMap<>();
        
        int p=0;
        
       
        
        for(List<Integer> prefHats:hats){
            personToHats.put(p++,new HashSet<>(prefHats));
            set.addAll(prefHats);
        }
        List<Integer> uniqueHats=new ArrayList<>(set);
        
         dp=new Long[uniqueHats.size()+1][(1<<personToHats.size())+1];
     
        
        return (int)(solve(uniqueHats,personToHats,0,0)%mod);
        
    }
    
    public long solve(List<Integer> uniqueHats,HashMap<Integer,HashSet<Integer>> personToHats,int index,int mask){
            
          

            if(check(mask,personToHats.size())){
                return 1;
            }
        
            if(index == uniqueHats.size()){
                return 0;
            }
        
            if(dp[index][mask]!=null)return dp[index][mask];
        
        
            long count=0;
            int hat=uniqueHats.get(index);     
            count+=solve(uniqueHats,personToHats,index+1,mask);
            for(int i=0;i<personToHats.size();i++){
                if((mask&(1<<i))==0 && personToHats.get(i).contains(hat)){
                    count=(count+solve(uniqueHats,personToHats,index+1,(mask|(1<<i))))%mod;
                }       
        }
        return  dp[index][mask] = count;
    }
}