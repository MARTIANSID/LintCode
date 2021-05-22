class Solution {
        
        
        public void swap(int[] arr,int i,int j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
        }
        
        public void reverse(int[] arr,int i,int j){
                while(i<j){
                        swap(arr,i++,j--);
                        
                }
        }
        
   public void rotate(int[] arr, int k) {
        
           int n=arr.length;
           int r=k;
           r%=n;
           
           reverse(arr,0,n-1);
                reverse(arr,r,n-1);
           reverse(arr,0,r-1);
          
           
            
            
    }
}