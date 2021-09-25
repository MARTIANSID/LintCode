class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        Collections.sort(dictionary,(a,b)->{
           
            if(a.length()==b.length()){
                return a.compareTo(b);
            }
            
            return b.length()-a.length();
            
        });
        
        for(int i=0;i<dictionary.size();i++){
            if(isSubsequence(s,dictionary.get(i)))return dictionary.get(i);
        }
        
        return "";
       
    }
    
    
    
    public boolean isSubsequence(String a,String b){
       
        int j=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(j)){
                j++;
                if(j==b.length())return true;
            }
        }
        return false;
    }
}