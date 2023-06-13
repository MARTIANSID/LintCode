class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            StringBuilder k=new StringBuilder();
            for(int j=0;j<n;j++){
                k.append(grid[i][j]+",");
            }
            String s=new String(k);
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int cnt=0;
        
         for(int i=0;i<n;i++){
            StringBuilder k=new StringBuilder();
            for(int j=0;j<n;j++){
                k.append(grid[j][i]+",");
            }
            String s=new String(k);
            cnt+=(map.getOrDefault(s,0));
        }
        return cnt;
        
    }
}