class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();
        
        // from a point nearest candle 
        
        // int[] left=new int[n];
        int[] right=new int[n];
        int[] prefix=new int[n];
        
        
        Arrays.fill(right,n);
        
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='|'){
                right[i]=i;
            }else{
                if(i!=n-1)
                right[i]=right[i+1];
            }
        }
        
        int start=0,plates =0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='|'){
                if(start==0){
                    plates=0;
                    start=1;
                }else{
                    prefix[i]=plates;
                    
                }
            }else{
                plates++;
                if(i!=0)
                prefix[i]=prefix[i-1];
            }
        }
        
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int ss=queries[i][0];
            int e=queries[i][1];
            
           int index= right[ss];
            
            if(index!=n&&index<e){
                ans[i]=prefix[e]-prefix[index];
            }else{
                ans[i]=0;
            }
        }
        
        
        return ans;
        
        
        
        
        
        
         
        
    }
}