class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length(),n2=s2.length();
        int si=0,ei=0;
        int[] freq=new int[26];
        int count=0;
        for(int i=0;i<n1;i++){
            freq[s1.charAt(i)-'a']++;
            if(freq[s1.charAt(i)-'a']==1)count++;
        }
        // System.out.println(count);
        while(ei<n2){
            freq[s2.charAt(ei++)-'a']--;
            if(freq[s2.charAt(ei-1)-'a']==0)count--;
            if(ei-si>n1){
                freq[s2.charAt(si++)-'a']++;
                if(freq[s2.charAt(si-1)-'a']==1)count++;
            }
            if(ei-si == n1 && count == 0)return true;
        }
        return false;
    }
}