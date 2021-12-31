class Solution {
    int mod=(int)1e9+7;
    public int countPairs(int[] deliciousness) {
        int n=deliciousness.length;
        long ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
    
        for(int ele:deliciousness){
            for(int i=0;i<=21;i++){
               int sum= (int)Math.pow(2,i);
                if(map.containsKey((sum-ele))){
                    ans=(ans+map.get(Math.abs(sum-ele)))%mod;
                }
            }
            
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        return (int)ans;
    }
}