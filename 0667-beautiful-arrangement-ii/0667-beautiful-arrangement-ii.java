class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] ans = new int[n];
        
        
        ans[0] = 1;
        ans[1] = 1 + k;
        
        int index = 2;
        
        
        HashSet<Integer> set = new HashSet<>();
        
        set.add(1);
        set.add(1+k);
        
        boolean flag = false;
    
        
        for(int abs = k - 1; abs >= 1; abs--) {
            
            if(!flag) {
                ans[index] = ans[index-1] - abs;
                set.add(ans[index]);
                
                flag = true;
            } else {
                ans[index] = ans[index-1] + abs;
                set.add(ans[index]);
                flag = false;
            }
            index++;
        }
        
        int val = -1;
        
        for(int i = 1; i <=n ; i++) {
            if(!set.contains(i)){
                val = i;
                break;
            }
        }
        
        
        if(val != -1) {
            for(int i = val; i <=n; i++){
                ans[index++] = i;
            } 
        }
    

        return ans;
        
    }
}


// n = 10, k = 6
    
// [1,2] , k = 5, n = 8

// [1,2,4] , absDiff = 3, n = 7, k = 4
// [1,2,4,7] , absDiff = 4, n = 6, k = 3
// [1,2,4,7,11], absDiff = 5, n = 5, k = 2
// [1,2,4,7,11,16], absDiff = 6, n = 4, k = 1
// [1,2,4,7,11,16,22], absDiff = 6, n = 3, k = 0
    
// [1,2,4,7,11,16,22,28,34,40]




// n = 3, k = 1 (1 distinct abs difference) -> ()
    
//  k = 0

//  - > [1,2,3]
    



// n = 3, k = 2  (2 distinct abs differences) -> (3)
    
//     k = 0
// [1,2,4]



// n = 5, k = 3

//[1,2,3,4]

// [1,3,4,2,5] = [2,1,2,3]

// n = 9, k = 8 = abs differences - [1 -- 8]
// [1,3,4,5,6,7,8,9,2] = [1,2,3,4,5,6,7] (distinct abs diff)
    
// abs = 8
// abs = 7
// abs = 6
// abs = 5   
// abs = 4
// abs = 3
// abs = 2
// abs = 1
    
// [1,9,2,8,3,7,4,6,5]



