class Solution {
    public int minFlips(String s) {
        int n1=s .length();
        s+=s;
        int min1=0,min2=0,n=s.length();
        
        
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        
        for(int i =0;i<s.length();i++){
            sb1.append(i%2==0?'0':'1');
            sb2.append(i%2==0?'1':'0');
        }
        String s1=new String(sb1);
        String s2=new String(sb2);
        
        int ei=0,si=0,min=(int)1e9;
        while(ei<n){
            if(s.charAt(ei)!=s1.charAt(ei)){
                min1++;
            }else{
                min2++;
            }
            ei++;
            
            if(ei-si>n1){
                if(s.charAt(si)!=s1.charAt(si)){
                    min1--;
                }else{
                    min2--;
                }
                si++;
            }
            if(ei-si==n1)
            min=Math.min(min,Math.min(min1,min2));
        }
        return min;
    }
}