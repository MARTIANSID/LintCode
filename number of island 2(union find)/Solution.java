/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**  
    * @param n: An integer
    * @param m: An integer
    * @param operators: an array of point
    * @return: an integer array



    */

    public int findParent(int[] parent,int u){
        if(parent[u]==u){
            return u;
        }
        int x=findParent(parent,parent[u]);
        parent[u]=x;
        return x;
    }
public List<Integer> numIslands2(int n, int m, Point[] operators) {
    // write your code here
    int[][] water=new int[n][m];

    int[] parent=new int[n*m]; 

    if(operators==null){
        return new ArrayList<>();
    }

    for(int i=0;i<n;i++){

        for(int j=0;j<m;j++){
                water[i][j]=0;
                parent[i*m+j]=i*m+j;
        }
    }  


    int islands=0;

    List<Integer> ans=new ArrayList<>();

      int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

for(int i=0;i<operators.length;i++){
        int x=operators[i].x;
        int y=operators[i].y;

        if(water[x][y]!=1){
                water[x][y]=1;

                islands++;

      for (int d = 0; d < 4; d++) {
                int x1 = x + dir[d][0];
                int y2 = y + dir[d][1];
                if (x1 >= 0 && y2 >= 0 && x1 < n && y2 < m && water[x1][y2] == 1) {
                  
                 int p1= findParent(parent,x*m+y);
                  int p2=findParent(parent,x1*m+y2);

                  if(p1!=p2){
                      parent[p1]=p2;
                      islands--;
                  }
                
            
                }
            }



        }else{

        }

        ans.add(islands);
    


    }


    return ans;

}
}