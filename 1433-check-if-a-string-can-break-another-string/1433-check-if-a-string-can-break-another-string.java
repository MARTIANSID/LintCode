class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n=s1.length();
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(int i=0;i<n;i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        boolean flag1=true,flag2=true;
        int count1=0,count2=0;
        for(int i=0;i<26;i++){
            count1+=freq1[i];
            count2+=freq2[i];
            if(count2<count1){
                flag2=false;   
            }
            if(count1<count2){
                flag1=false;
            }
            if(!flag1 && !flag2)return false;
        }
        
        return true;
    }
}