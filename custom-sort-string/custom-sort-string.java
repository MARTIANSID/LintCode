class Solution {
    public String customSortString(String order, String str) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
             map.put(order.charAt(i),0);
        }
        
        String ans="";
        
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                ans+=str.charAt(i);
                
            }else{
                
            int x=    map.get(str.charAt(i));
                x++;
                map.put(str.charAt(i),x);
                            
            }
        }
        
        String a="";
          for(int i=0;i<order.length();i++){
              int x=  map.get(order.charAt(i));
              for(int j=0;j<x;j++){
                  a+=order.charAt(i);
              }
        }
        
        return ans+a;
    }
}




