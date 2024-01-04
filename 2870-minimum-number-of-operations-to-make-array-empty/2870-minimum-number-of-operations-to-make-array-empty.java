class Solution {
    public int minOperations(int[] nums) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        Set<Integer> set=map.keySet();
        
        int ans=0;
        
        for(int key : set){
            int freq=map.get(key);
            
            if(freq == 1)return -1;
            
            if(freq%3==0){
                ans += (freq/3);
            }else if(freq%3==1){
                ans += ((freq/3)-1)+2;
            }else{
                ans += (freq/3)+1;
            }
        }
        return ans;
    }
}


//  n % 3 = 0 (then fine)

//  (ek 3 chodo)
//  n % 3 = 1

//  n % 3 = 2