class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
            int count=0;
           for(int i=0;i<r;i++){
                   int[] arr=new int[c];
                   for(int j=i;j<r;j++){
                           HashMap<Integer,Integer> map=new HashMap<>();
                           for(int k=0;k<c;k++)arr[k]+=matrix[j][k];
                           
                           
                           map.put(0,1);
                           int sum=0;
                     
                                for(int t=0;t<arr.length;t++){
                                    sum+=arr[t];
                                        if(map.containsKey(sum-target)){
                                            count+=map.get(sum-target);
                                    }
                                    if(map.containsKey(sum)){
                                            
                                            map.put(sum,map.get(sum)+1);
                                    }else{
                                            map.put(sum,1);
                                    }
                                    
                                    
                            }
                                
                        }
                        }
                            
                   
           
            return count;
    }
}