class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n+1][m+1];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=(matrix[i-1][j-1]^dp[i][j-1]^dp[i-1][j]^dp[i-1][j-1]);
                
                pq.add(dp[i][j]);
            }
        }
        
        while(k-->1){
            pq.poll();
        }
        
        return pq.poll();

        
    }
}