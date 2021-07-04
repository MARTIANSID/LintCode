class Solution {
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
                          
                         