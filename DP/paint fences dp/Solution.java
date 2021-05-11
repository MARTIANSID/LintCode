public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {

        return solve(n,k,-1,0);
       
    }
    public int solve(int n,int k,int painted,int adj){
        if(n==0)return 1;

int count=0;
    if(adj<1){
        for(int i=0;i<k;i++){
              if(i==painted){
               count+=   solve(n-1,k,i,adj+1);
              }else{
                count+=  solve(n-1,k,i,adj);

              }

        }

    }else{
         for(int i=0;i<k;i++){
            if(i!=painted){
                 count+=solve(n-1,k,i,0);
            }

        }



    }

    return count;

}
}