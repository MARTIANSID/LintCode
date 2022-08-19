class Solution {
    public boolean isPossible(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> required=new HashMap<>();
        
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        
        for(int ele:nums){
            if(map.getOrDefault(ele,0)>0){
                int freq=required.getOrDefault(ele,0);
                if(freq>0){
                    required.put(ele,freq-1);
                    required.put(ele+1,required.getOrDefault(ele+1,0)+1);
                }else{
                    int req=ele+1;
                    int k=2;
                    while(k-->0){
                        int f=map.getOrDefault(req,0);
                        if(f>0){
                            map.put(req,f-1);
                            req=req+1;
                        }else{
                            return false;
                        }
                    }
                    required.put(req,required.getOrDefault(req,0)+1);
                }
                map.put(ele,map.getOrDefault(ele,0)-1);
            }
            
        }
        
        return true;
          
    }
}



// 1,2,3

// [1,2,3,3,4,5]

// [1,2,3,3,4,4,5,5]
