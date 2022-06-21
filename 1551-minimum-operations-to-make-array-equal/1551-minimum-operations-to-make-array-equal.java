class Solution {
    //   we need to convert every number to  n
  
//   2*(n-n)+1 --(n-1) -->1
      
//   2*(n-(n-1))+1 (n-3)
      
//       (n-1)+(n-3)
      
//       =2*n-4
      
    public int minOperations(int n) {
            return (n*n)/4;
    }
}



      
      
      
  