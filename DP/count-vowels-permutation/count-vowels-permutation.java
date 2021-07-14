class Solution {
        int mod=(int)1e9+7;
    public int countVowelPermutation(int n) {
        char[] vowels  =new char[]{
                'a' ,'e','i','o','u'
        };
            
            long[][] dp=new long[n+1][7];
            
        for(long[] row:dp)Arrays.fill(row,-1);
            
            
            return (int)solve(n,vowels,dp,-1);
            
            }
        
        private long solve(int n,char[] vowels,long[][] dp,int index){
                
                if(n==0)return   dp[n][index]= 1;
                
                
                
                 if(index!=-1&&dp[n][index]!=-1){
                      return   dp[n][index];
                }
                
                long count=0;
                
                        if(index==-1){
                                for(int i=0;i<vowels.length;i++){
                                count=(count+solve(n-1,vowels,dp,i))%mod;
                                }
                        }else{
                               
                                
                                if(vowels[index]=='a'){
                                        count=(count+solve(n-1,vowels,dp,1))%mod;
                                        
                                }else if(vowels[index]=='e'){
                                        count=(count+solve(n-1,vowels,dp,0))%mod;
                                                                                                                                        count=(count+solve(n-1,vowels,dp,2))%mod;

                                }else if(vowels[index]=='i'){
                                                                                                                                count=(count+solve(n-1,vowels,dp,0))%mod;
                                                                                                                        count=(count+solve(n-1,vowels,dp,1))%mod;
                                                                count=(count+solve(n-1,vowels,dp,3))%mod;
                                        count=(count+solve(n-1,vowels,dp,4))%mod;


                                        
                                }else if(vowels[index]=='o'){
                                                                                count=(count+solve(n-1,vowels,dp,2))%mod;
                                        count=(count+solve(n-1,vowels,dp,4))%mod;

                                        
                                }else if(vowels[index]=='u'){
                                                                                                                                count=(count+solve(n-1,vowels,dp,0))%mod;

                                        
                                }
                        }
                
                if(index!=-1){
                        dp[n][index]=count;
                }
                return   count;
        }
        
}