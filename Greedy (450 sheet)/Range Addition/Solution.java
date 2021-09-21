

public class Solution {

    public int[] rangeAddition(int[][] queries,int n){
        int[] ans=new int[n];
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            if(queries[i][1]==n-1){
                ans[start]+=queries[i][2];
            }else{
               ans[start]+=queries[i][2];
               ans[queries[i][1]+1]-=queries[i][2];
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=ans[i];
            ans[i]=sum;
        }
       return ans;
    }
    public static void main(String[] args){

    }
}
