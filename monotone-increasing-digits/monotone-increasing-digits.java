class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        int breakPoint=-1;
        String str=n+"";
        
        char prev=str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(Character.getNumericValue(prev)>Character.getNumericValue(str.charAt(i))){
                    breakPoint=i-1;   
                    break;
            }
            
            prev=str.charAt(i);
        }
        
        char[] ch=str.toCharArray();
        int start=0;
      
        if(breakPoint!=-1)
        for(int i=breakPoint;i>=0;i--){
            int val=    Character.getNumericValue(ch[i])-1;
            ch[i]=(char)(val+'0');    
            start=i;
            if(i-1>=0&&Character.getNumericValue(ch[i-1])<=val)break;
            
        }
        
        
        
        if(breakPoint!=-1)
        for(int i=start+1;i<ch.length;i++){
            ch[i]=(char)(9+'0');
            
        }
        
        String ans=new String(ch);
            return Integer.parseInt(ans);
        
    }
}

// 299
// 22210