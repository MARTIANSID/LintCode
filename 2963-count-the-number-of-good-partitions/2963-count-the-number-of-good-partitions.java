class Solution {
    int mod=(int)1e9+7;
    public int numberOfGoodPartitions(int[] nums) {
        int n=nums.length;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        HashSet<Integer> set=new HashSet<>();
        
        int sub=0;
        
        for(int ele:nums){
            int freq=map.get(ele);
            freq--;
            map.put(ele,freq);
            if(freq == 0){
                map.remove(ele);
                set.remove(ele);
            }
            if(freq!=0)set.add(ele);
            
            if(set.size() == 0){
                sub++;
            }
            
        }
        
    
        return pow(2,sub-1);
    }
    public int pow(long a, long b){
        long res=1;
        while(b>0){
            if(b%2==0){
                b/=2;
                a=(a*a)%mod;
            }else{
                res=(res*a)%mod;
                b--;
            }
        }
        return (int)(res%mod);
    }
}


