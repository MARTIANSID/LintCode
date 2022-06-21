class Solution {
    
    /*
    logic - > (i,j,k)
    xor from (i,j-1) is equal lets say a
    xor from (j,k) is equal to lets say b
    now both of these xor are equal that means a^b=0
    that also means xor of number from (i,k) is zero
    
    now lets we found a found two points some i and k for which xor from (i,k) is zero
    in btw there will some points lets say  i,j1,j2,j3,j4,k points j1,j2,j3,j4 will be our possible answer
    why?
    consider xor from (i,j1) =a
    and xor from (j3,k) = b
    a will be equal to b because (a^b)=0 (when two values gives xor as zero that means a=b)
    
    */
    
    public int countTriplets(int[] arr) {
        int n=arr.length;
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            int ele=arr[i];
            int xor=ele;
            for(int j=i+1;j<n;j++){
                xor^=arr[j];
                if(xor==0){
                    ans+=(j-i);
                }
            }
        }
        return ans;
    }
}