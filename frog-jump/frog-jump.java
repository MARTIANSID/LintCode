class Solution {
    public boolean canCross(int[] stones) {
        
            HashMap<Integer,Integer> map=new HashMap<>();
            
            for(int i=0;i<stones.length;i++){
                    map.put(stones[i],i);
            }
            // int[][] dp=new int[stones.length][stones[stones.length-1]];
            
            HashMap<String,Boolean> dp=new HashMap<>();
            
            return solve(stones,map,0,0,dp);
    }
        
        public boolean solve(int[] stones,HashMap<Integer,Integer> map,int index,int jump,HashMap<String,Boolean>  dp){
                
                
                if(index==stones.length-1){
                       dp.put(index+" "+jump,true);
                        return  true;
                }
                
                
                if(dp.containsKey(index+" "+jump)){
                        return dp.get(index+" "+jump);
                }
                
                
                boolean x=false;
                boolean y=false;
                boolean z=false;
                boolean m=false;
                if(index==0){
                        if(map.containsKey(stones[index]+1)){
                             
                                  z=  solve(stones,map,map.get(stones[index]+1),1,dp);
                        if(z)return true;
                        }
                    
                        
                }else{
                        
                         
                if(map.containsKey(stones[index]+jump+1)){
                       
                        x=solve(stones,map,map.get(stones[index]+jump+1),jump+1,dp);
                        if(x)return true;
                        
                }
                if(jump-1>0)
                 if(map.containsKey(stones[index]+jump-1)){
                        y=solve(stones,map,map.get(stones[index]+jump-1),jump-1,dp);
                        if(y)return true;
                }
                        
                        
                                 
                if(map.containsKey(stones[index]+jump)){
                        m=solve(stones,map,map.get(stones[index]+jump),jump,dp);
                        if(m)return true;
                        
                }
                        
                        
                        
                }
               
                    dp.put(index+" "+jump,false);
                return false;
                
                
                
                
                
        }
}