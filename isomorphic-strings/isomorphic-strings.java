class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length()!=t.length())return false;
        HashMap<Character,Character> map=new HashMap<>();
        // boolean[] visited=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            // System.out.println(map);
            
                
                if(map.containsKey(ch1)){
                   char ch= map.get(ch1);
                    if(ch!=ch2)return false;
                }else{
                    if(!map.containsValue(ch2)){
                        map.put(ch1,ch2);
                        // visited[ch2-'a']=true;
                    }else{
                        return false;
                    }
                
               
            }
         
        }
         return true;
    }
}