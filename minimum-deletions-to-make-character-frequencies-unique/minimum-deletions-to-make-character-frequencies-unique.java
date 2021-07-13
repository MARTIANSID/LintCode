class Solution {
    public int minDeletions(String s) {
        int[] freq=new int[26];
        int ans=0;
        
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            int f=freq[s.charAt(i)-'a'];
            for(int j=0;j<26;j++){
                if(f==0)break;
                if(j!=s.charAt(i)-'a'&&freq[j]==f){
                    j=0;
                    f--;
                    ans++;
                }
            }
            freq[s.charAt(i)-'a']=f;
        }
        
        return ans;
    }
}