class Solution {
    
    class pair{
        int r;
        int c;
        int val;
        pair(int r,int c,int val){
            this.r=r;
            this.c=c;
            this.val=val;
        }
    }
    
    int[][] dir=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n=grid.length;
        int m=grid[0].length;
        int size=queries.length;
        int index=0;
        
        int[] prefix=new int[(int)1e6+2];
        
        int[] ans=new int[size];
        
        PriorityQueue<pair> que=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        boolean[][] visited=new boolean[n][m];
        visited[0][0]=true;
        que.add(new pair(0,0,grid[0][0]));
        
        int max=0;
        
        while(que.size()!=0){
            int s=que.size();
            while(s-->0){
                pair p=que.poll();
                max=Math.max(max,p.val);
                 prefix[max+1]++;
            
                for(int i=0;i<4;i++){
                    int r=p.r+dir[i][0];
                    int c=p.c+dir[i][1];
                    if(r>=0 && c>=0 && r<n && c<m && !visited[r][c]){
                        visited[r][c]=true;
                        que.add(new pair(r,c,grid[r][c]));
                    }
                }
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int ele:queries){
            set.add(ele);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        
    
        
        int sum=0;
        for(int i=0;i<prefix.length;i++){
            sum+=prefix[i];
            if(set.contains(i)){
                map.put(i,sum);
            }
        }
        for(int ele : queries){
            ans[index++]=map.get(ele);
        }
        return ans;
        
    }
}