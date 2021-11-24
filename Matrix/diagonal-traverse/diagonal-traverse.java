class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
         int n=mat.length;
         int m=mat[0].length;
        
         HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map.containsKey(i+j)){
                    map.get(i+j).add(mat[i][j]);
                }else{
                    List<Integer> diag=new ArrayList<>();
                    diag.add(mat[i][j]);
                    map.put(i+j,diag);
                }
            }
        }
       
        
        int[] ans=new int[n*m];
        boolean flag=false;
        int index=0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
	        List<Integer> diag=entry.getValue();
            if(!flag){
                for(int i=diag.size()-1;i>=0;i--){
                    ans[index++]=diag.get(i);
                    
                }
            }else{
                for(int i=0;i<diag.size();i++){
                    ans[index++]=diag.get(i);
                }
                
            }
            flag=!flag;
        }
        
        return ans;
    }
}
