class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n=words1.length;
        int m=words2.length;
        int[] wd2Freq=new int[26];
        
        List<String> ans=new ArrayList<>();
        

        for(String word:words2){
            int[] freq=new int[26];
            for(int i=0;i<word.length();i++){
                freq[word.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                wd2Freq[i]=Math.max(freq[i],wd2Freq[i]);
            }
        }
        int index=0;
        
        for(String word:words1){
            int[] freq=new int[26];
            for(int i=0;i<word.length();i++){
                freq[word.charAt(i)-'a']++;
            }
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(wd2Freq[i]>0 && wd2Freq[i]>freq[i]){
                    flag=false;
                    break;
                }
            }
            
            if(flag){
                ans.add(word);
            }
            
        
        }
        return ans;
        
    }
}