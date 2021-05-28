class Solution {
    public int maxVowels(String s, int k) {
        
            int si=0;
            int ei=0;
            int n=s.length();
            int vowels=0;
            int max=0;
           
            while(ei<n){
                 char ch=s.charAt(ei);
                  if(Vowel_Or_Consonant(ch)){
                          vowels++;
                  }
                    ei++;
                    
                    while(ei-si>k){
                          char c=  s.charAt(si);
                        if(Vowel_Or_Consonant(c)){
                          vowels--;
                  } 
                            si++;
                            
                           
                    }
                    
                    max=Math.max(vowels,max);
            }
            return max;
    }
        
         public boolean Vowel_Or_Consonant(char y)
        {
        if (y == 'a' || y == 'e' || y == 'i' || y == 'o'
            || y == 'u')
        return true;
        else
           return false;
        }
}