class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod=(int)1e9+7;
           HashMap<Integer,Boolean> map=new HashMap<>();
            int num=0;
            for(int ele:arr){
                  num=  Math.max(ele,num);
                    map.put(ele,true);
            }
            
           HashMap<Integer,Long> dp=new HashMap<>();
            
            long ans=0;
            for(int i=0;i<arr.length;i++){
                    ans+=solve(arr[i],arr,map,dp);
            }
            
            return (int)(ans%mod);
            
    }
        public long solve(int num,int[] arr,HashMap<Integer,Boolean> map,HashMap<Integer,Long> dp){
                
                if(dp.containsKey(num))return dp.get(num);
                
                long count=1;
              for(int i=0;i<arr.length;i++){
                      if(num%arr[i]==0&&map.containsKey(num/arr[i])){
                                             
                            count+=solve(arr[i],arr,map,dp)*solve(num/arr[i],arr,map,dp);
                              
                      }
              }  
                dp.put(num,count);
                return count;
                
        }
        
       
}
