class Solution {
    public int tribonacci(int n) {
        
        
        int s1=0,s2=1,s3=1;
        
        if(n==0)return 0;
        if(n<3)return 1;
        
        n-=3;
        int ans=0;
        
        while(n>=0){
            ans=s1+s2+s3;
            s1=s2;
            s2=s3;
            s3=ans;
            n--;
            
        }
        return ans;
    }
}

