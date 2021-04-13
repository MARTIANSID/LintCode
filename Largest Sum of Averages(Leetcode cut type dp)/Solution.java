class Solution {
        
        
    
    public double largestSumOfAverages(int[] A, int K) {
        
            double[][] dp=new double[A.length+1][K+1];
            
            for(double[] row:dp) Arrays.fill(row,-1);
           
            return solve(A,K,0,0,dp);
    }
        public double solve(int[] a,int k,int index,int prev,double[][] dp){
                
                if(index==a.length){
                      return dp[index][k]=-(int)1e9;
                        
                }
                 double sum=0;
                if(dp[index][k]!=-1)return dp[index][k];
                if(k==1){
                         for(int i=index; i<a.length; i++)
                         sum += a[i];
        return dp[index][k]=sum/(a.length-index);
                }
               
                double x=-(int)1e9;
               for(int i=index;i<a.length;i++){
                      sum += a[i];
   double   avg = sum/(i-index+1);
                   x=Math.max(x,avg+solve(a,k-1,i+1,i+1,dp));
                       
                    
                       
               } 
                
                return dp[index][k]=x;
        }
        
            
//         public double sum(int prev,int index,int[] a){
//                 double sum=0;
//                 int count=0;
             
//                if(index==prev){
//                        // System.out.println(index);
//                        return a[prev];
//                }
                
//                 for(int i=prev;i<=index;i++){
//                         count++;
//                         sum+=a[i];
//                 }
                
                
    
             
}