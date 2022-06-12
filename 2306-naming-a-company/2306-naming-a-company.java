class Solution {
    public long distinctNames(String[] ideas) {
        long[][] freq=new long[26][26];
        
        HashSet<String> set=new HashSet<>();
        
        for(String w:ideas){
            set.add(w);
        }
        
        for(String w:ideas){
            int i=w.charAt(0)-'a';
            StringBuilder sb=new StringBuilder(w);
            for(int j=0;j<26;j++){
                if(i==j)continue;
                sb.setCharAt(0,(char)(j+'a'));
                if(!set.contains(new String(sb)))freq[i][j]++;
            }
        }
        long count=0;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                count+=freq[i][j]*freq[j][i];
            }
        }
        return count;
        
    }
}