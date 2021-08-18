class Solution {
    public boolean compare(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]!=0&&freq2[i]!=0){
                return false;
            }
        }
        return true;
    }
    
    public int maxProduct(String[] words) {
        
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            int[] freq=new int[26];
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                freq[ch-'a']++;
                map.put(i,freq);
                
            }
        }
        
        int max=0;
        for(int i=0;i<words.length;i++){
            String word=words[i];
            for(int j=i+1 ;j<words.length;j++){
               if(compare(map.get(i),map.get(j))){
                   max=Math.max(max,word.length()*words[j].length());
               }
            }
        }
        
        return max;
        
    }
}
