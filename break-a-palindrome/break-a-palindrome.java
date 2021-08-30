class Solution {
    public String breakPalindrome(String palindrome) {
        
        int n=palindrome.length();
        if(n==1)return "";
        
        int mid=n/2;
        
        char[] ch=palindrome.toCharArray();
                            
        for(int i=0;i<n;i++){
            if(i==mid&&n%2!=0){
                        continue;
            }else{
                
                if(i==n-1){
                     if(ch[i]!='a'){ch[i]='a';break;}
                    else ch[i]='b';
                    break;
                }
                if(ch[i]!='a'){ch[i]='a';break;}
                
            }
        }
        
    String ans=new String(ch);
        
        return ans;
    }
}