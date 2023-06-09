class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        
        int si=0,ei=n-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(letters[mid] > target){
                ei=mid-1;
            }else{
                si=mid+1;
            }                                           
        }
        
        return letters[si >= n ? 0 : si];
    }
}