class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int n1=sentence1.length();
        int n2=sentence2.length();
        
        int start1=0,start2=0;
        
        String[] s1=sentence1.split(" ");
        String[] s2=sentence2.split(" ");
        
        int end1=s1.length-1,end2=s2.length-1;
        
        
        while(start1<=end1 && start2<=end2){
            if(s1[start1].equals(s2[start2])){
                start1++;
                start2++;
            }else if(s1[end1].equals(s2[end2])){
                end1--;
                end2--;
            }else{
                return false;
            }
        }
        return true;
        
    }
}