class Solution {
    public boolean isAnagram(String s, String t) {
          char tempArray[] = s.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
       String one= new String(tempArray); 
            
            
             char f[] = t.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(f); 
              String two= new String(f); 
            
            return one.equals(two);
            
    }
}