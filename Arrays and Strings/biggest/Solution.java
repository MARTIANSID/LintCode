class Solution {
    String printLargest(String[] arr) {
            Arrays.sort(arr,(a,b)->{
       
        return (a+b).compareTo(b+a);
        
           
            
            });
            
            String q="";
            
            for(int i=arr.length-1;i>=0;i--){
                q+=arr[i];
            }
            
            
            
            return q;
    }
}