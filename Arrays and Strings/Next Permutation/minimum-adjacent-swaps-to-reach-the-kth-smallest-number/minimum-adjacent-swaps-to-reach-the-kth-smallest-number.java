class Solution {
    public int getMinSwaps(String num, int k) {
            
            int n=num.length();
            int[] nums=new int[n];
            int[] copy=new int[n];
            for(int i=0;i<n;i++){
                    nums[i]=Character.getNumericValue(num.charAt(i));
                    copy[i]=Character.getNumericValue(num.charAt(i));
            }
            
            while(k-->0)nextPermutation(nums);
            
            int swaps=0;
          
            for(int i=0;i<n;i++){
                    if(copy[i]==nums[i])continue;
                    
                    int no=nums[i];
                    
                    for(int j=i+1;j<n;j++){
                            if(copy[j]==no){
                                    while(copy[i]!=no){
                                            int temp=copy[j];
                                            copy[j]=copy[j-1];
                                            copy[j-1]=temp;
                                            swaps++;
                                            j--;
                                            
                                    }
                                    break;
                            }
                    }
            }
            
         
            
            return swaps;
      
    }
         public void nextPermutation(int[] A) {
            int n=A.length;
            int i=n-2;
            while(i>=0&&A[i]>=A[i+1])i--;
            
            int j=n-1;
        if(i>=0){
        while(i>=0&&j>=0&&A[j]<=A[i])j--;
            swap(A,i,j);
            
        }
            reverse(A,i+1,n-1);
    }
        public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}
        
        
  

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}
        
}