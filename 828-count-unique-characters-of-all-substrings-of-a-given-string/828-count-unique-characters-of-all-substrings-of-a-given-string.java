class Solution {

    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                left[i]=map.get(ch);
            }else{
                left[i]=-1;
            }
            map.put(ch,i);
        }
        
        map.clear();
        
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                right[i]=map.get(ch);
            }else{
                right[i]=n;
            }
            map.put(ch,i);
        }
        int count=0;
        
        for(int i=0;i<n;i++){
            int l=left[i],r=right[i];
            count+=(i-l)*(r-i);
        }
        return count;
    }
}
// ->"ABC"
