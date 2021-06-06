class Solution {
        public int findParent(int val,HashMap<Integer,Integer> map){
                if(map.get(val)==val){
                        return val;
                }
                
                
               int x= findParent(map.get(val),map);
                map.put(val,x);
                return x;
        }
        
    public int longestConsecutive(int[] nums) {
            
       
            if(nums.length==0)return 0;
            
           HashMap<Integer,Integer> map=new HashMap<>();
           
        for(int i=0;i<nums.length;i++){
               map .put(nums[i],nums[i]);
        }
            
            
            for(int i=0;i<nums.length;i++){
                    if(map.containsKey(nums[i]+1)){
                         int p1=   findParent(nums[i]+1,map);
                         int p2=findParent(nums[i],map);
                           if(p1!=p2){
                                   map.put(p1,p2);
                           }
                    }
                    
                    
                      if(map.containsKey(nums[i]-1)){
                         int p1=   findParent(nums[i]-1,map);
                         int p2=findParent(nums[i],map);
                           if(p1!=p2){
                                   map.put(p1,p2);
                           }
                    }
                    

            }
            
            HashMap<Integer,Integer> m=new HashMap<>();
            HashMap<Integer,Integer> visited=new HashMap<>();
            int max=1;
            for(int i=0;i<nums.length;i++){
                 if(!visited.containsKey(nums[i])){
                          int x= findParent(nums[i],map);
                    
                    
                    if(m.containsKey(x)){
                        int y=    m.get(x);
                            
                          m.put(x,y+1);
                            max=Math.max(max,y+1);
                    }else{
                            m.put(x,1);
                    }
                         visited.put(nums[i],1);
                 }
            }
            
            return max;
           
    }
}