class Solution {

    public int minDeletions(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> freq = new ArrayList<>();

        for (Map.Entry mapElement : map.entrySet()) {
            freq.add((int)mapElement.getValue());
        }
        Collections.sort(freq);
        
        int size=freq.size(),deletions=0;
        
        
        for(int i=size-2;i>=0;i--){
            if(freq.get(i)>=freq.get(i+1)){
                int val=(freq.get(i)-(freq.get(i+1)==0?1:freq.get(i+1)))+1;
                deletions+=val;
                freq.set(i,freq.get(i)-val);
            }
        }
        return deletions;
    }
}
