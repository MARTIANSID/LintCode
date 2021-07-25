class Solution {
    String solve(int[] arr, int n) {
       Arrays.sort(arr);
       
       int carry=0;
       String a="";
        for(int i=n-2;i>=0;i-=2){
            int result=arr[i]+arr[i+1]+carry;
            // System.out.println(result);
            carry=result/10;
            int x=result%10;
            a+=x;
        
            
        }    
        if(n%2!=0){
            int result=   arr[0]+carry;
            a+=result;
        }else if(carry!=0){
            a+=carry;
        }
        
        
      a=  new StringBuilder(a).reverse().toString();
      String fa="";
     boolean num=false;
      for(int i=0;i<a.length();i++)
      {
          if(a.charAt(i)=='0'&&!num){
              continue;
          }else{
              num=true;
              fa+=a.charAt(i);
          }
      }
      
      return fa;
        
    }
}