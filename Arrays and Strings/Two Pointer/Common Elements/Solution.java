class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        int i=0,j=0,k=0;
        
        ArrayList<Integer> ans=new ArrayList<>();
        while(i<n1 && j<n2 && k<n3){
            if(A[i]==B[j]&&A[i]==C[k]){
                ans.add(A[i]);
                i++;
                j++;
                k++;
                while(i<n1&&A[i]==A[i-1])i++;
                while(j<n2&&B[j]== B[j-1])j++;
                while(k<n3&&C[k]==C[k-1])k++;
                
            }
        
            
            else{
                
                   if(A[i]<=B[j]&&A[i]<=C[k]){
                        i++;
                   }else if (B[j]<=A[i]&&B[j]<=C[k]){
                       j++;
                   }else if(C[k]<=A[i]&&C[k]<=B[j]){
                       k++;
                   }
            }
        }
        
        return ans;
      
    }
}