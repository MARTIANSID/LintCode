class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n=words.length;
        HashMap<Character,TreeSet<Integer>> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.putIfAbsent(ch,new TreeSet<>());
            map.get(ch).add(i);
        }
        
        int count=0;
        
        for(String word:words){
            int prevIndex=-1;
            boolean flag=true;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(!map.containsKey(ch)){
                    flag=false;
                    break;
                }
                TreeSet<Integer> list=map.get(ch);
                Integer index=list.higher(prevIndex);
                if(index==null){
                    flag=false;
                    break;
                }
                prevIndex=index;
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}