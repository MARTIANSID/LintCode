class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n=points.length;
        int m=queries.length;
        
        int[] result=new int[m];
        for(int i=0;i<m;i++){
            int x=queries[i][0],y=queries[i][1],r=queries[i][2],ans=0;
            
            for(int j=0;j<n;j++){
                int xP=points[j][0],yP=points[j][1];
                
                int dist=(int)Math.pow(x-xP,2)+(int)Math.pow(y-yP,2);
                if(dist<=Math.pow(r,2)){
                    ans++;
                }
            }
            result[i]=ans;
        }
        return result;
    }
}