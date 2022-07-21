class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n=queries.length,m=s.length(),xor=0;
        int[] prefix=new int[m];
        
        for(int i=0;i<m;i++){
            char ch=s.charAt(i);
            xor^=(1<<(ch-'a'));
            prefix[i]=xor;
        }
       
        
        List<Boolean> ans=new ArrayList<>();
        
        for(int[] q:queries){
            int l=q[0],r=q[1],k=q[2],len=(r-l+1);
            int xorSub= l == 0 ? prefix[r] : prefix[l-1]^prefix[r];
            int odd=Integer.bitCount(xorSub);
            if(len%2!=0)odd--;
        
            if(odd%2!=0 || odd/2>k){
                ans.add(false);
            }else{
                ans.add(true);
            }
        }
        return ans;
    }
}



// "aaaaaa"
    