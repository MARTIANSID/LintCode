class Solution {
    public int maximumSwap(int num) {
        
        String s=num+"";
        
        int n=s.length();
        
        int[] right=new int[s.length()];
        int max=-1;
        int index=-1;
        for(int i=n-1;i>=0;i--){
            int x=Character.getNumericValue(s.charAt(i));
            if(x>max){
                max=x;
                index=i;
            }
            right[i]=index;
        }
        
        for(int i=0;i<s.length()-1;i++){
          int x=  right[i+1];
            if(Character.getNumericValue(s.charAt(x))>Character.getNumericValue(s.charAt(i))){
               return  swap(x,i,s);
              
            }
            
        }
        
        return Integer.parseInt(s);
    }
    public int swap(int i,int j,String s){
        char[] c = s.toCharArray(); 
        char temp = c[i];
c[i] = c[j];
c[j] = temp;
        
    String ans=new String(c);
        return Integer.parseInt(ans);
        
    }
}