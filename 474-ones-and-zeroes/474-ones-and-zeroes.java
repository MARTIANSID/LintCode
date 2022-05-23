class Solution {
    
    class pair{
        int ones;
        int zeros;
        pair(int ones,int zeros){
            this.ones=ones;
            this.zeros=zeros;
        }
    }
    
    Integer[][][] dp;
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        dp=new Integer[strs.length][m+1][n+1];
     
        HashMap<String,pair> map=new HashMap<>();
        
        for(String s:strs){
           pair p= countOnesZeros(s);
           map.put(s,p);
        }
        
        return solve(map,strs,m,n,0);
        
    }
    public pair countOnesZeros(String s){
        int ones=0,zeros=0;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch == '1')ones++;
            else zeros++;
        }
         return new pair(ones,zeros);
    }
    
    public int solve(HashMap<String,pair> map,String[] strs,int m,int n,int index){
        
        
        if(index == strs.length){
            return 0;
        }
        
        if(dp[index][m][n]!=null)return dp[index][m][n];
        
        pair p=map.get(strs[index]); 
        
        int ones=p.ones;
        int zeros=p.zeros;
        
        int take=0,leave=0;
        
        if(m >=zeros && n >=ones){
            take=solve(map,strs,m-zeros,n-ones,index+1)+1;
        }
        
        leave=solve(map,strs,m,n,index+1);
        
        return dp[index][m][n]= Math.max(take,leave);
        
    }
   
}