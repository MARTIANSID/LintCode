class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
            if((s1+s2).length()<s3.length()){
                    return false;
            }
            
            
            int[][][] dp=new int[s1.length()+1][s2.length()+1][s3.length()+1];
            
            return solve(s1,s2,s3,0,0,0,dp);
            
            
            
            
    }
        
        public boolean solve(String s1,String s2,String s3,int i,int j,int k,int[][][] dp){
                
                
                if(k==s3.length()&&i==s1.length()&&j==s2.length())return true;
                
                if(k==s3.length()&&(i!=s1.length()||j!=s2.length()))return false;
                
                
                
                if(dp[i][j][k]!=0)return false;
                
                
                
                if(i<s1.length()&&s1.charAt(i)==s3.charAt(k)){
                       boolean x= solve(s1,s2,s3,i+1,j,k+1,dp);
                        if(x)return true;
                } 
                
        if(j<s2.length()&&s2.charAt(j)==s3.charAt(k)){
                     boolean y=   solve(s1,s2,s3,i,j+1,k+1,dp);
                        if(y)return true;
                }
                
                dp[i][j][k]=-1;
                return   false;
                
        }
}