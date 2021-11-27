class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        
        for(List<String> x:knowledge){
             String key=x.get(0);
             String value=x.get(1);
            map.put(key,value);
        }
        
    String ans="";
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(s.charAt(i)=='('){
                String a="";
                i++;
                while(s.charAt(i)!=')'){
                    a+=s.charAt(i);
                    i++;
                }
                if(map.containsKey(a))
                ans+=map.get(a);
                else
                    ans+="?";
            
            }else{
                ans+=ch;
            }
        }
        return ans;
    }  
}