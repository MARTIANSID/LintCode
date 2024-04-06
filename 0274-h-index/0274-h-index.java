class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        int si = 0, ei =  5001;
        
        while(si<=ei){
            
            int mid = (si+ei)/2;
            
            if(isPossible(mid,citations)){
                si = mid+1;
            } else {
                ei = mid-1;
            }
        }
        
        return ei;
    }
    
    public boolean isPossible(int mid, int[] citations){
        int cnt = 0;
        
        for(int ele : citations){
            if(ele>=mid){
                cnt++;
            }
        }
        if(cnt >= mid)return true;
        
        return false;
        
    }
}


// (1-->INT.MAX)
// [1,10] 
// mid = 5 
// [3 4] 


// [1,10]
// [1,2,3,4]

// si = 1
// ei = 10
// mid = 5
// ei = mid - 1 = 4
    
    
// si = 1
// ei = 4

// mid = 2
// ei = mid -1

    
// si = 1
// ei = 1


// [1,3,1]
