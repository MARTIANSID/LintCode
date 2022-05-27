class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> result=new ArrayList<>();
        
        int si=0,ei=arr.length-1;
        
        int n=arr.length;
        
        boolean found=false;
        
        
        while(si<=ei){
            int mid=(ei+si)/2;
            if(arr[mid]>target){
                ei=mid-1;
            }else if(arr[mid]<target){
                si=mid+1;
            }else{
                found=true;
                if(mid-1>=0 && arr[mid-1]==arr[mid]){
                    ei=mid-1;
                }else{
                    si=mid;
                    break;
                }
            }
        }
        
        if(!found)return new ArrayList<>();
        
        // starting index will be at si
        int i=si+1;
        result.add(si);
        while(i<n && arr[si] == arr[i])result.add(i++);
        
        return result;
    
    }
}