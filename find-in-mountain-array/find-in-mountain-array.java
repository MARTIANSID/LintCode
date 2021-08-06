/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
            // finding the peak first
            int l=0,r=mountainArr.length()-1,n=mountainArr.length(),peak=-1;
        
        while(l<=r){
            int mid=(l+r)/2;
            if(mid-1>=0 && mountainArr.get(mid) >mountainArr.get(mid-1)&&mid+1<n&&mountainArr.get(mid)>mountainArr.get(mid+1)){
                peak=mid;
                break;
            }else if(mid-1>=0 && mountainArr.get(mid) <mountainArr.get(mid-1)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        
       
        if(target==mountainArr.get(peak))return peak;
        
        l=0;
        r=peak-1;
        
     
        
        while(l<=r){
            int mid=(l+r)/2;
                int x=  mountainArr.get(mid);
            if(x==target)return mid;
            else if(x>target)r=mid-1;
            else l=mid+1;
        }
        
        l=peak+1;
        r=n-1;
                while(l<=r){
            int mid=(l+r)/2;
                 int x=  mountainArr.get(mid);
            if(x==target)return mid;
            else if(x>target)l=mid+1;
            else r=mid-1;
        }
        
        
        return -1;
    }
    

}