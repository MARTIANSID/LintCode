class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);       
        
        left[0]=1;
        for(int i=1;i<n;i++){
            if(arr[i-1]<=arr[i]){
                left[i]=1;
            }else{
                break;
            }
        }
        
        right[n-1]=1;
        
        for(int i=n-2;i>=0;i--){
            if(arr[i+1]>=arr[i]){
                right[i]=1;
            }else{
                break;
            }
        }
        
        int ei=n,si=0;
        
        while(si<=ei){
            int mid=(ei+si)/2;
            
            if(isPossible(mid,arr,left,right)){
                ei=mid-1;
            }else{
                si=mid+1;
            }
        }
        
        
        
        return si;
        
        
    }
    
    public boolean isPossible(int size,int[] arr,int[] left,int[] right){
        for(int i=0;i<=(arr.length-size);i++){
            if(i==0){
                if(right[i+size]==1)return true;
            }else if(i==arr.length-size){
                if(left[i-1]==1)return true;
            }else{
                if(left[i-1]==1&&right[i+size]==1&&arr[i-1]<=arr[i+size])return true;
            }
        }
        return false;
    }
}






// [1,2,3,10,4,2,3,5]//////Ww