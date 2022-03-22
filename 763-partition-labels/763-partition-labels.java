class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashSet<Character> set=new HashSet<>();
        
        List<Integer> ans=new ArrayList<>();
        
        int prev=-1;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int freq=map.get(ch);
            freq--;
            
            if(freq==0){
                map.remove(ch);
                set.remove(ch);
            }else{
                map.put(ch,freq);
                set.add(ch);
            }
            
            
            if(set.size()==0){
                ans.add(i-prev);
                prev=i;
            }
        }
        
        return ans;
    }
    
}