class Solution {
    //cut type dp 
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
            
                Arrays.fill(dp,-1);
            
            return solve(arr,k,0,dp);
            
            
    }
        
        public int solve(int[] arr,int k,int index,int[] dp){
                
                if(index>=arr.length){
                        return dp[index]= 0;
                }
                
                
                if( dp[index]!= -1)return  dp[index];
                
                
                
                 int max=-(int)1e9;
//          if(k==1){
                 
//         for(int i=index; i<arr.length; i++)
//         max= Math.max(arr[i],max);
              
//         return max*(arr.length-index);
                
                 
//                         }
                
                
                
             int x=-(int)1e9;
               for(int i=index;i<arr.length;i++){
                       
                       if(i-index+1>k){ 
                break;
            }
               
                    max=Math.max(max,arr[i]);
                     // max=  getMaxNum(index,i,arr);
                           // System.out.println(max);
                     // System.out.println(max*(i-index+1));
   // double   avg = sum/(i-index+1);i
                   x=Math.max(x,max*(i-index+1)+solve(arr,k,i+1,dp));
                                            // System.out.println(x);

                    
                       
               } 
                return dp[index]=  x;
                
        }
        
//         public int  m(int start ,int end ,int [] arr){
//                 int max=0;
//                 for(int i=start;i<end;i++){
//                       max=Math.max(max,arr[i]);  
//                 }
                
//                 return max;
//         }
         public int getMaxNum(int start,int end,int[] arr){
        int maxNum=0;


        for(int i=start;i<=end;i++){
            maxNum=Math.max(maxNum,arr[i]);
        }


        return maxNum;
    }
}