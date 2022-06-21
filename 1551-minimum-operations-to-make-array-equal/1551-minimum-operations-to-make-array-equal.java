class Solution {
   /*  we need to convert every number to  n 
   
   Generally in such type of questions we want to convert every number to the middle value that is median
   
   and for this quation median for every n is equal to n
   
   we can prove this
   
   for n=odd
   median will be the center value  = 2*((n-1)/2)+1 = n and the center index =(n-1)/2 (when n=odd)
   
   for n=even
   median will be the average of the center values = (2*((n/2 -1)/2) +1 + 2*(n/2) +1 )/2 which again result in value =n
   
 now we want to convert every value to n
 
 therefore
  first value = 1 ,steps required = n-1
  
  second value = 3 ,steps required = n-3
  
  so on we continue only for n/2 values
      
 n-1 + n-3 + n-5 ...
 this forms a gp
 
 this will give us value =(n*n)/4
     
    */
      
    public int minOperations(int n) {
            return (n*n)/4;
    }
}



      
      
      
  