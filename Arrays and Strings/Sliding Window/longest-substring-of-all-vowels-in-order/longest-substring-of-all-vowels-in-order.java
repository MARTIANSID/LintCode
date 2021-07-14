class Solution {
    public int longestBeautifulSubstring(String s) {
        
    int count=5;
    char c='a';
    char prev='@';
    int max=0;
    int ei=0,si=0,n=s.length();
        
        while(ei<n){
            char ch=s.charAt(ei);
            ei++;
            if(prev!='@'&&prev==ch){
                if(count==0){
                    
                  max=  Math.max(max,ei-si);
                }
                continue;
            }
            // System.out.println(count);
            if(ch==c){
                count--;
                prev=c;
                if(c=='a'){
                    c='e';
                }else if(c=='e'){
                    c='i';
                }else if(c=='i'){
                    c='o';
                }else if(c=='o'){
                    c='u';
                }
            }else if(ch!=c){
                
                si=ei;
                c='a';
                count=5;
                  prev='@';
               if(ch=='a'){
                   si=ei-1;
                   c='e';
                    count=4;
                   prev='a';
               }
              
           
                
                
            }
            
            if(count==0){
                max=Math.max(max,ei-si);
            }
            
            
            
        }
        return max;
    
    }
    // 1->2->3->4->5
    // 1->3->5->  2->4
    
//     1->2->3
//        1->3 ->2 
    // 1->2
    
    
    
        
}

