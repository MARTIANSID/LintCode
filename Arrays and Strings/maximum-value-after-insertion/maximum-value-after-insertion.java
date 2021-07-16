class Solution {
    public String maxValue(String n, int x) {
        StringBuilder str=new StringBuilder(n);
        
        
     boolean isNegetive=false,inserted=false;
        if(n.charAt(0)=='-')isNegetive=true;
        
        
        if(isNegetive){
                
            for(int i=1;i<n.length();i++){
                if(x<Character.getNumericValue(n.charAt(i))){
                      str.insert(i, (char)(x+'0'));
                    inserted=true;
                    break;
                }
            }
            if(!inserted){
                str.insert(n.length(),(char)(x+'0'));
            }
            
        }else{
            
              for(int i=0;i<n.length();i++){
                if(x>Character.getNumericValue(n.charAt(i))){
                      str.insert(i, (char)(x+'0'));
                    inserted=true;
                    break;
                }
            }
            if(!inserted){
                str.insert(n.length(),(char)(x+'0'));
            }
        
            
        }
        
        String ans=new String(str);
        return ans;
    }
}