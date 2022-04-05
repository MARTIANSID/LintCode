class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();


        for (String w : words) {
            
            HashMap<Character,Integer> patternMap = new HashMap<>();
            
            HashMap<Character,Integer> wordMap = new HashMap<>();
            
            int index=0;
            
            boolean flag=true;
            
           if(w.length() == pattern.length()){
               for(int i=0;i<w.length();i++){
                   char ch1=w.charAt(i);
                   char ch2=pattern.charAt(i);
                   int index1=wordMap.getOrDefault(ch1,-1);
                   int index2=patternMap.getOrDefault(ch2,-1);
                   
                   if(index1!=index2){
                       flag=false;
                       break;
                   }
                   
                   wordMap.put(ch1,i);
                   patternMap.put(ch2,i);
                   
                   
               }       
           }
            
            if(flag){
                ans.add(w);
            }
            
            
        }

        return ans;
    }
}
