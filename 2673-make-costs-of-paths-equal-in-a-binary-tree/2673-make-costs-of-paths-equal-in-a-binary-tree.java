class Solution {
    int cnt=0;
    public int minIncrements(int n, int[] cost) {
        dfs(cost,1);
        return cnt;
    }
    public int dfs(int[] cost,int index){
        if(2*index>cost.length)return cost[index-1];
        
        int left=dfs(cost,2*index);
        int right=dfs(cost,2*index+1);
        
        cnt+=Math.abs(left-right);
        return Math.max(left,right)+cost[index-1];
    }
}