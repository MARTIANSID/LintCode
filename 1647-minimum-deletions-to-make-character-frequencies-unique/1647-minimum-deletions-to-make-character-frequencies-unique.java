class Solution {
    public int minDeletions(String s) {
        int[] charCount = new int[26];
        
        for(char ch : s.toCharArray()){
            charCount[ ch - 'a'] ++;
        }
        
        HashSet<Integer> set = new HashSet<>();
        int deletion = 0;
        
        for(int val : charCount){
            while(val !=0 && set.contains(val)){
                val--;
                deletion++;
            }
            set.add(val);          
        }
       
        return deletion;
    }
}