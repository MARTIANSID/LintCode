class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        int max=0;
        
        int[][] dp=new int[arr.length+1][arr.length+1];
        
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        
       for(int[] row:dp)Arrays.fill(row,-1);
        
        for(int i=0;i<arr.length;i++){
               
                max=Math.max(max,solve(arr,i,-1,dp,map)+1);
        }
        
        
        return max>=3?max:0;
        
    }
    
    public int solve(int[] arr,int index,int prev,int[][] dp,HashMap<Integer,Integer> map){
        
        
        if(index==arr.length)return 0;
        
        if(dp[index][prev+1]!=-1)return dp[index][prev+1];
        
        int a=0;
            for(int i=index+1;i<arr.length;i++){
                if(prev==-1){
                    a=Math.max(a,solve(arr,i,index,dp,map)+1);
                }else{
                    if(map.containsKey(arr[index]+arr[prev])){
                        
                        a=Math.max(a,solve(arr,map.get(arr[index]+arr[prev]),index,dp,map)+1);
                    }else{
                        break;
                    }
                }
            }
        
        return   dp[index][prev+1]=a;
        
        
    }
    
    
}