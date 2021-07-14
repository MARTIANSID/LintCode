class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())return false;
        
        HashMap<Character,Integer> map=new HashMap<>();
         int count=0;
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
         if(map .containsKey(ch)){
          int x=   map.get(ch);
             map.put(ch,x+1);
         }else{
             count++;
             map.put(ch,1);
         }
            
        }
        
        
        
     
//       System.out.println(count);
    // System.out.println(map);
        
                for(int i=0;i<s2.length();i++){
            if(!map.containsKey(s2.charAt(i)))map.put(s2.charAt(i),0);
         
            
        }
                        // System.out.println(map);

        
    
        
        
        
        int si=0,ei=0,n=s2.length();
        
        while(ei<n){
           while(ei-si<s1.length()-1){
               char ch=s2.charAt(ei);
               ei++;
               
               int freq=map.get(ch);
               freq--;
                if(freq==0){
                    
                   count--;
               }
               map.put(ch,freq);
              
               
           }
            
            // if(ei-si==s1.length()-1){
            //     System.out.println(ei);
            //     System.out.println(map);
            //     System.out.println(count);
            // }
            
//             if(ei==n-2){
//                 System.out.println(count);
//                 System.out.println(map);
//                 System.out.println(si);
//             }
            
            
           
            
            
            
//             if(ei==n-1){
//                   System.out.println(count);
//                 System.out.println(map);
//                 System.out.println(si);
//             }
            
             char ch=s2.charAt(ei);
               ei++;
//             if(ei==n){
//                 System.out.println(map);
//                 System.out.println(count);

//             }
               int freq=map.get(ch);
            freq--;
              if(freq==0){
                   count--; 
               }
               map.put(ch,freq);
             
//              if(ei==n){
//                 System.out.println(map);
//                 System.out.println(count);

//             }
            
             
        // System.out.println(count);
            
            
            // if(count==0)System.out.println(si);
            
            if(count==0)return true;
            
            int f=map.get(s2.charAt(si));
            map.put(s2.charAt(si),f+1 );
            if(f+1==1){
                count++;
            }
//              if(ei==n){
                // System.out.println(map);
//                 System.out.println(count);

//             }
            
            si++;
            

            
            
        }
        return false;
    }
}