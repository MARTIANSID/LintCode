class Solution {
    public int numSteps(String s) {
        int n=s.length();
        
        int ones=0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')ones++;
        }
        
        int i=n-1,carry=0,steps=0;
        
        while(i>=0){
            char ch=s.charAt(i);
            
            if(i==0 && ((ch=='1' && carry==0) || (ch=='0' && carry==1)))return steps;
            
            if(carry==0 && ch=='0'){
                i--;
                steps++;
            }else if(carry==0 && ch=='1'){
                carry=1;
                i--;
                steps+=2;
            }else if(carry==1 && ch=='1'){
                carry=1;
                i--;
                steps+=1;
            }else{
                carry=1;
                i--;
                steps+=2;
            }
        }
        
        return steps;
        
    }
}
