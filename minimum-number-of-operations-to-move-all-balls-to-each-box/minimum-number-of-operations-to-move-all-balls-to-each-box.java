class Solution {
    public int[] minOperations(String s) {
        int n=s.length();
        
       
        int[] right=new int[n];
        int[] left=new int[n];
        
        int ans=0;
        int ones=0;
        for(int i=n-1;i>=0;i--){
            ans+=ones;
            if(s.charAt(i)=='1')ones++;
            right[i]=ans;
        }
        ones=0;
        ans=0;
        for(int i=0;i<n;i++){
            ans+=ones;
            if(s.charAt(i)=='1')ones++;
            left[i]=ans;
        }
        
        int[] a=new int[n];
        
        for(int i=0;i<n;i++){
            a[i]=right[i]+left[i];
        }
        return a;
    
    }
}   



