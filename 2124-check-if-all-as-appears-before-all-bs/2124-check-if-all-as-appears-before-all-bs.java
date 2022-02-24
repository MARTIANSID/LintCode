class Solution {
    public boolean checkString(String s) {
        
        int bCount=0;
        
        int n=s.length();
       
        
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='b'){
                if(bCount>0)return false;
            }else{
                bCount++;
            }
        }
        return true;
    }
}