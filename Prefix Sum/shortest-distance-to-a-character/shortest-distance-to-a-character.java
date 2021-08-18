class Solution {
    public int[] shortestToChar(String s, char c) {
        int n=s.length();
        int[] left=new int[n];
        int[] right=new int[n];
        
        int prev=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                prev=i;
            }
            left[i]=prev;
        }
        
        prev=-1;
        for(int i=n-1;i>=0;i--){
             if(s.charAt(i)==c){
                prev=i;
            }
            right[i]=prev;
        }
        
        
        int[] ans=new int[n];
      
        for(int i=0;i<n;i++){
                int x=left[i];
                int y=right[i];
                if(x!=-1&&y!=-1){
                     int min=(int)1e9;
                    min=Math.min(min,Math.min(i-x,y-i));
                    ans[i]=min;
                }else if(x==-1&&y!=-1){
                    
                    ans[i]=y-i;
                    
                }else if(y==-1&&x!=-1){
                    ans[i]=i-x;
                }
        }
        return ans;
    }
}