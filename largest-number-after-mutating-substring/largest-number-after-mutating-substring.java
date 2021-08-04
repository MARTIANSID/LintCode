class Solution {
    public String maximumNumber(String num, int[] change) {
        boolean expand=false;
        
        int ei=0,si=0;
        int n=num.length();        
        while(ei<n){
         int no = Character.getNumericValue(num.charAt(ei++));
        if(no<change[no]){
            expand=true;
        }else if(no==change[no]&&expand!=true){
            expand=false;
            si++;
        }else if(no==change[no]&&expand==true){
            expand=true;
        }
            
            else if(expand==true){
            ei--;
            break;
        }else{
            si++;
        }
            
        }
        
        
    
        char[] arr=num.toCharArray();
        for(int i=si;i<ei;i++){
            arr[i]=(char)(change[ Character.getNumericValue(num.charAt(i))]+'0');
        }
        String ans=new String(arr);
        return ans;
    }
}