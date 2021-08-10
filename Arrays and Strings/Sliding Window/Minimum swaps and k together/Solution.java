class Solution{
    

    //make a window size of number of elements <= k ,then find the window which contains minimum numbers which are greater than k
    public static int minSwap (int arr[], int n, int k) {
        int ei=0,si=0,count=0;
        int c=0,min=(int)1e9;
        
       for(int i=0;i<arr.length;i++){
           if(arr[i]<=k)count++;
       }
       
       if(count==0)return 0;
       
       while(ei<n){
           while(ei-si<count-1){
                if(arr[ei]>k)c++;
                ei++;
           }
            if(arr[ei]>k)c++;
            ei++;
            min=Math.min(min,c);
           if(arr[si]>k)c--;
           si++;
        
           
           
       }
       return min;
    }
    
    
}
