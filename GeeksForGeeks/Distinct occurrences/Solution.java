class Solution
{
    int mod=(int)1e9+7;
    int  subsequenceCount(String S, String T)
    {
        int[][] arr=new int[S.length()+1][T.length()+1];
        
        for(int[] row:arr)Arrays.fill(row,-1);
	
	return solve(S,T,0,0,arr);
	
	
    }
    public int solve(String s,String t,int i,int j,int[][] arr){
        
        
        int count=0;
        if(j==t.length()){
            return arr[i][j]=1;
        }
        if(i==s.length()){
            return arr[i][j]=0;
        }
        if(arr[i][j]!=-1)return arr[i][j];
        
        if(s.charAt(i)==t.charAt(j)){
        int x=    solve(s,t,i+1,j+1,arr);
        int y=solve(s,t,i+1,j,arr);
        return arr[i][j]= (x+y)%mod;
        }else{
            
        int u=    solve(s,t,i+1,j,arr);
        return arr[i][j]= u%mod;
            
        }
        
    }
}