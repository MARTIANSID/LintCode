class Solution {
    public int minimumLength(String s) {
        int i=0,j=s.length()-1,ans=s.length();
        
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                char first=s.charAt(i);
                char last=s.charAt(j);
                while(i<j&&s.charAt(i)==first){
                    i++;
                    if(i<=j)
                    ans=j-i+1;
                }
                if(i==j)return 0;
                while(j>i&&s.charAt(j)==last){
                   
                    j--;
                    if(j>=i)
                     ans=j-i+1;
                }  
            }else{
                break;
            }
        }
       
        if(i>j)return 0;
        if(i==j)return 1;
        return ans;
    }
}