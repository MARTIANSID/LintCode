class Solution {
    public int longestMountain(int[] arr) {
        
        
        int n=arr.length;
        int max=0;
            for(int i=0;i<arr.length-1;i++){
                //increasing
                int countIncreasing=1;
                boolean f=false;
                boolean flag=false;
                while(i+1<n&&arr[i]<arr[i+1]){
                    flag=true;
                    countIncreasing++;
                    i++;
                }
                
                
                //decreasing
                int countDecreasing=0;
                while(i+1<n&&arr[i]>arr[i+1]){
                    f=true;
                    countDecreasing++;
                    i++;
                }
                
                if(f||flag)
                i--;
                
                
                if(f&&flag){
                    max=Math.max(max,countIncreasing+countDecreasing);
                }
                
                
                
            }
        
        return max;
    }
}




