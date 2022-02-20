class Solution {
    
    class pair{
        char ch;
        int freq;
        pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    
    public String repeatLimitedString(String s, int repeatLimit) {
            
        char[] chArr=s.toCharArray();
        
        
        
        
        
        Arrays.sort(chArr);
        
        // int[] freq=new int[26];
        
        String ans="";
        StringBuilder sb=new StringBuilder();
        
        int n=chArr.length;
        
        if(n==0)return "";
        
        if(n==1)return s;
        // char prevChar=chArr[n-1];
        // int prevCharFreq=1;
        
        Deque<pair> charArr=new ArrayDeque<>();
        
        char prev=chArr[n-1];
        
        int freq=1;
        int i=n-2;
       while(i>=0){
            char ch=chArr[i];
            while(ch==prev){
                freq++;
                i--;
                if(i<0){
                    charArr.add(new pair(prev,freq));
                    break;
                }
                ch=chArr[i];
            }
            if(i<0)break;
            charArr.add(new pair(prev,freq));
            if(i==0){
                charArr.add(new pair(chArr[i],1));
                break;
            }
           
           if(i<0)break;
           
            prev=chArr[i--];
           
           
            freq=1;
        }
        
        i=0;
         
          
        
       char prevChar=charArr.peek().ch;
        // ans+=prevChar+"";
        sb.append(prevChar);
        charArr.peek().freq--;
        int prevCharFreq=1;
        
        
       
        
        while(charArr.size()>0){
            
            
            char ch=charArr.peek().ch;
            
            
            
            if(charArr.peek().freq==0){
                charArr.pop();
                continue;
            }
           
            if(ch==prevChar){
                if(prevCharFreq>=repeatLimit){
                    if(i+1<charArr.size()){
                        pair p1=charArr.removeFirst();
                        char c=charArr.peek().ch;
                        charArr.peek().freq--;
                        if(charArr.peek().freq==0){
                            
                            pair p2=charArr.removeFirst();
                           
                        }
                         charArr.addFirst(p1);
                        sb.append(c);
                        prevChar=c;
                        prevCharFreq=1;
                        continue;
                    }else{
                       break;
                    }
                }else{
               sb.append(ch);
                prevCharFreq++;
                }
                
            }else{
                sb.append(ch);
                prevChar=ch;
                prevCharFreq=1;
            }
            
            charArr.peek().freq--;
            if(charArr.peek().freq==0){
                charArr.removeFirst();
            }
            
        }
        
        
        
        return new String(sb);
    }
}