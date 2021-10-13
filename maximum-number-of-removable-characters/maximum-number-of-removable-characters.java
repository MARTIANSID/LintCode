class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int si=0,ei=removable.length-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(check(s,p,mid,removable)){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        
        return si;
        
    }
    
    public boolean check(String s,String p,int k,int[] remove){
        
        
        char[] ch=s.toCharArray();
        for(int i=0;i<=k;i++){
            ch[remove[i]]='&';
        }
        return sub(ch,p);
        
    }
    
    public boolean sub(char[] ch,String p){
        
        int index=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='&')continue;
            
            if(ch[i]==p.charAt(index))index++;
            if(index==p.length())return true;
        }
        return false;
        
    }
    
    
}