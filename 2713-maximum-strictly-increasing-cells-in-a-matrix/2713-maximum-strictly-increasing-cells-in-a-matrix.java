import java.util.*;

class Solution {

  /*
   * https://www.youtube.com/watch?v=Chl2-fBuSOs
   */

  class pair {
    int row;
    int col;
    int val;

    pair(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }

  public int maxIncreasingCells(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int result=-1;

    List<pair> values = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        values.add(new pair(i, j, mat[i][j]));
      }
    }
    Collections.sort(values, (a, b) -> {
      return b.val - a.val;
    });
    int[] colMax = new int[m];
    int[] rowMax = new int[n];
      
    Arrays.fill(colMax,-1);
    Arrays.fill(rowMax,-1);

    for (int i = 0; i < values.size(); i++) {
      pair p = values.get(i);
      int row = p.row, col = p.col, val = p.val;

      HashMap<Integer, Integer> lRowMax = new HashMap<>();
      HashMap<Integer, Integer> lColMax = new HashMap<>();

      while (i < values.size() && values.get(i).val == val) {
        p = values.get(i);
        row = p.row;
        col = p.col;
        int ans=Math.max(colMax[col],rowMax[row])+1;
        lRowMax.put(row,Math.max(lRowMax.getOrDefault(row,-1),ans));
        lColMax.put(col,Math.max(lColMax.getOrDefault(col,-1),ans));
        i++;
      }
      i--;
      Set<Integer> rows=lRowMax.keySet();
      Set<Integer> cols=lColMax.keySet();

      for(int r:rows){
        rowMax[r]=Math.max(rowMax[r],lRowMax.get(r));
        result=Math.max(result,rowMax[r]);
      }
      for(int c:cols){
        colMax[c]=Math.max(colMax[c],lColMax.get(c));
        result=Math.max(result,colMax[c]);
      }

    }
    return result+1;

  }
}