// { Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    
    int mod=(int)1e9+7;
    Long[][] dp;
    int  subsequenceCount(String s, String t)
    {
        dp=new Long[s.length()][t.length()];
        
        return (int)(solve(s,t,0,0)%mod);
		
    }
    
    public long solve(String s,String t,int i,int j){
        
        
        if(j==t.length())return 1;
        
        if(i==s.length())return 0;
        
        
        if(dp[i][j]!=null)return dp[i][j];
        
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= (solve(s,t,i+1,j+1)%mod+(solve(s,t,i+1,j))%mod)%mod;
        }else{
            return dp[i][j]= solve(s,t,i+1,j);
        }
        
    }
}