class Solution {
  boolean isConnected(int[] bomb1, int[] bomb2) {
    long x1 = bomb1[0], y1 = bomb1[1], r1 = bomb1[2], x2 = bomb2[0], y2 = bomb2[1], r2 = bomb2[2];
    //use eqn of circle
    long x=x1-x2;
    long y=y1-y2;
      

    if((x*x+y*y)>r1*r1)return false;

    return true;
  }

  public int maximumDetonation(int[][] bombs) {
    int n = bombs.length;
    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j != i) {
          int[] bomb1 = bombs[i], bomb2 = bombs[j];
          if (isConnected(bomb1, bomb2)) {
            graph.get(i).add(j);
          }

        }
          

      }
    }


    int max = -1;
    for (int i = 0; i < n; i++) {
     boolean[] visited=new boolean[n];
      
        max = Math.max(max, dfs(graph, i, visited));
    }

    return max;

  }

  public int dfs(List<List<Integer>> graph, int src, boolean[] visited) {

    visited[src] = true;
    int cnt = 1;
    for (int child : graph.get(src)) {
      if (!visited[child]) {
        cnt += dfs(graph, child, visited);
      }
    }
    return cnt;
  }
}