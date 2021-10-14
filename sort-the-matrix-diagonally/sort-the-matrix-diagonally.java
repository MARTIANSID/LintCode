class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] matrix=new int[n][m];
        
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!map.containsKey(i-j))map.put(i-j,new PriorityQueue<>());
                map.get(i-j).add(mat[i][j]);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=map.get(i-j).poll();
            }
        }
        return matrix;
        

                
        
    }
}