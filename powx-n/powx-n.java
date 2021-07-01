class Solution {
    public double myPow(double x, int n) {
        
            
            
            if(n<0){
                   return 1/solve(x,-n);
            }else{
                    return solve(x,n);
            }
            
    }
        
        public   double solve(double x,int n){
                if(n==0)return 1;
                if(n==1)return x;
                
                double z=solve(x,n/2);
                
          if(n%2==0){
                return   z*z;
                  
          }else{
                  return x*z*z;
          }
            
        }
}