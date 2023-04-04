class Solution {
    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    class pair {
        int row;
        int col;
        int t;

        pair(int row, int col, int t) {
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }

    public int minimumTime(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> {
                return a.t - b.t;
            }
        );

        pq.add(new pair(0, 0, grid[0][0]));

        boolean[][] visited = new boolean[n][m];

        int values = 0;
        
        boolean flag=false;
        
        if(1<m && grid[0][1]<=1)flag=true;
    
        if(1<n && grid[1][0]<=1)flag=true;
        
        if(!flag)return -1;

        while (pq.size() != 0) {
            int size = pq.size();
            while (size-- > 0) {
                pair val = pq.poll();
                int r = val.row, c = val.col, t = val.t;

                if (r == n - 1 && c == m - 1) return t;

                if (visited[r][c]) continue;

                visited[r][c] = true;
                values++;

                for (int i = 0; i < dir.length; i++) {
                    int row = r + dir[i][0];
                    int col = c + dir[i][1];
                    if (row >= 0 && col >= 0 && row < n && col < m) {
                        if (grid[row][col] > t + 1 && grid[row][col] % 2 == 0) {
                            pq.add(new pair(row, col, grid[row][col]+(t%2==0?1:0)));
                        } else if (grid[row][col] > t + 1 && grid[row][col] % 2 != 0) {
                            pq.add(new pair(row, col, grid[row][col]+t%2));
                        } else if (grid[row][col] <= t + 1) {
                            pq.add(new pair(row, col, t + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
