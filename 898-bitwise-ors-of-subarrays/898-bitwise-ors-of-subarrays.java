class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        
        HashSet<Integer> allUniqueValues=new HashSet<>(),prev=new HashSet<>();
        
        for(int ele:arr){
            HashSet<Integer> uniqueValuesEndingAtEle=new HashSet<>();
            for(int e : prev){  // At Max 30 elements will be present
                uniqueValuesEndingAtEle.add((ele|e));
                allUniqueValues.add((e|ele));
            }
            uniqueValuesEndingAtEle.add(ele);
            allUniqueValues.add(ele);
            prev=uniqueValuesEndingAtEle;
        }
        
        return allUniqueValues.size();
        
    }
}

/*
complexity analysis
 
 x1 x2 x3 x4
 
 if we see subarrays ending at x4 then subarrays are
 
 x1 x2 x3 x4 -- 1
 
 x2 x3 x4   --  2
 
 x3 x4 -- 3
 
 x4 -- 4
 
 1 > 2 > 3 > 4
 
 1 will have all set bits of 2 and so on
 
 now  0<=nums[i]<=10^9 so at max 30 bits will be there
 
 unique values at max can be 30  
 
 
 x1   ...  x50
 
 if we consider subarrays ending at x50 there will be 50 subarrays but unique values will only be 30 at max
 
 why?
 
because there are 30 bits and the subarray starting from x1 to x50 will contain set bits of all the intermediate subarrays that are x2 to x50 , x3 to x50 and so on.
 
 
 Therefore the overall timecomplexity of the solution is o(30*n)  n-> length of the array
 

*/