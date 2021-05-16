//simple brute force solution
class Solution {
    static ArrayList<ArrayList<String>> getGray(String S) {
        // code here
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
            
            palindrome(S,"",ans);
            
            return ans;
          
    }
    
     public static  void palindrome(String str,String asf,    ArrayList<ArrayList<String>> ans){
                
                if(str.length()==0){
                        
                      String[] result=asf.split(" ");
                        ArrayList<String> res=new ArrayList<>();
                        for(int i=0;i<result.length;i++){
                                res.add(result[i]);
                        }
                        res.remove(0);
                        ans.add(res);
                        return;
                }
                
        for(int i=0;i<str.length();i++){
                String sub=str.substring(0,i+1);
                String  ros=str.substring(i+1);
                
                if(isPalindrome(sub)){
                        palindrome(ros,asf+ " "+sub,    ans);
                }
                        
        }
        }
        
        public  static boolean isPalindrome(String str)
    {
 
   
        int i = 0, j = str.length() - 1;
 

        while (i < j) {
 
           
            if (str.charAt(i) != str.charAt(j))
                return false;
 
         
            i++;
            j--;
        }

        return true;
    }
    
};