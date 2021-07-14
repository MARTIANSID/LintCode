class Solution {
        
    public int maxSumSubmatrix(int[][] matrix, int target) {
        
      int r=matrix.length;
        int c=matrix[0].length;
            int max=-(int)1e9;
           for(int i=0;i<r;i++){
                   int[] arr=new int[c];
                   for(int j=i;j<r;j++){
                           for(int k=0;k<c;k++)arr[k]+=matrix[j][k];
                        
                  TreeSet<Integer> tree=new TreeSet<>();
                           tree.add(0);
                          
                           int sum=0;
                          for(int l=0;l<arr.length;l++){
                                  sum+=arr[l];
                                  
                                  Integer  result=tree.ceiling(sum-target);
                                  
                                                           

                                  
                                  if(result!=null){
                                    
                                         
                                          max=Math.max(max,sum-result);
                                  }
                                  
                                  tree.add(sum);
                                  
                                  
                                  
                                  
                          }
                           
                           // System.out.println(tree);
                           
                           
                           
                                                       
           }
                                    
           }   
           
            return max==-(int)1e9?-1:max;
    }
}