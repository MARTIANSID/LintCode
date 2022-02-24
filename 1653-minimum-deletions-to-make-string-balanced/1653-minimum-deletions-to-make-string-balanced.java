class Solution {
    public int minimumDeletions(String s) {
        //first ignore all the a on the left
        
        
        
        int n=s.length();
        
        if(n==1)return 0;
        
        int[] left=new int[n]; //track b
        int[] right=new int[n]; //trach a

        int bCount=0,aCount=0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b')bCount++;
            left[i]=bCount;
        }
        
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='a')aCount++;
            right[i]=aCount;
        }
        
        int ans=(int)1e9;
        for(int i=0;i<n;i++){
            if(i==0){
                ans=Math.min(ans,right[i+1]);
            }else if(i==n-1){
                ans=Math.min(ans,left[i-1]);
            }else{
                ans=Math.min(ans,right[i+1]+left[i-1]);
            }
        }
        
        return ans;

       
    }
}