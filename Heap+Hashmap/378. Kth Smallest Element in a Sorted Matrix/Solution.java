class Solution {
// rows are sorted so i converted this q into merge k sorted arrays


    public int kthSmallest(int[][] matrix, int k) {
      
          ArrayList<int[]> arr=new ArrayList<>();  
            
           int n=matrix.length;
            
            for(int i=0;i<n;i++){
                    arr.add(matrix[i]);
            }
            
            
           int[] ans=mergeSort(arr,0,arr.size()-1);
            
            return ans[k-1];
            
           
        
    }
        
        public int[] mergeSort(ArrayList<int[]> arr,int si,int hi){
                
                if(si==hi){
                        return arr.get(si);
                }
                
                
        int mid=(si+hi)/2;
           int[] right=    mergeSort(arr,mid+1,hi);
           int[] left=     mergeSort(arr,si,mid);
                
                
                return merge(right,left);
                
        }
        
        
        
        
 public  int[] merge(int[] a, int[] b) {

    int[] answer = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length)
    {
        if (a[i] < b[j])
        {
            answer[k] = a[i];
            i++;
        }
        else
        {
            answer[k] = b[j];
            j++;
        }
        k++;
    }

    while (i < a.length)
    {
        answer[k] = a[i];
        i++;
        k++;
    }

    while (j < b.length)
    {
        answer[k] = b[j];
        j++;
        k++;
    }

    return answer;
}       
        
        
        
}