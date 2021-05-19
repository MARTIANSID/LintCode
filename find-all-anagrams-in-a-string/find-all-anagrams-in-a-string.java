class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq=new int[26];
        
        for(int i=0;i<p.length();i++){
                char ch=p.charAt(i);
                
                freq[ch-'a']++;
        }
            String key="";
            for(int i=0;i<freq.length;i++){
                    key+=freq[i]+" ";
            }
            List<Integer> ans=new ArrayList<>();
            
            
         for(int i=0;i<s.length()&&i<=s.length()-p.length();i++){
                String ss= s.substring(i,i+p.length());
                // System.out.println(ss);
                 int[] freqq=new int[26];
                for(int j=0;j<ss.length();j++){
                char ch=ss.charAt(j);
                
                freqq[ch-'a']++;
        }
                  String keyy="";
            for(int j=0;j<freq.length;j++){
                    keyy+=freqq[j]+" ";
            }
                 if(keyy.equals(key)){
                         ans.add(i);
                 }
                
         }
            return ans;
    }
}