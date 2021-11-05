class Solution {
    public String largestMerge(String word1, String word2) {
        
        int n1=word1.length();
        int n2=word2.length();
        
        int i=0,j=0;
        String merged="";
        while(i<word1.length()&&j<word2.length()){
                if(word1.substring(i,n1).compareTo(word2.substring(j,n2))>0){
                    
                    merged+=word1.charAt(i);
                    i++;
                }else{
                    
                      merged+=word2.charAt(j);
                    j++;
                    
                }
        }
        
        if(i<n1){
            merged+=word1.substring(i,n1);
        }
        
        if(j<n2){
            merged+=word2.substring(j,n2);
        }
        
        return merged;
        
    }
}