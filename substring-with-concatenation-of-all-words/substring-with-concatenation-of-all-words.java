class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        int k=0;
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
            k=word.length();
        }
        List<Integer> ans=new ArrayList<>();
        int ei=0,si=0,wordCount=words.length,n=s.length();
        
        for(int i=0;i<s.length();i++){
            int count=words.length;
            int index=i;
            HashMap<String,Integer> temp=new HashMap<>(map);
            while(count-->0){
                if(index+k>s.length())break;
                String str=s.substring(index,index+k);
               
                index=index+k;
                if(!temp.containsKey(str)){
                    break;
                }
             int x=   temp.get(str);
                x--;
                if(x==0)temp.remove(str);
                else{
                    temp.put(str,x);
                }
            }
         
            if(temp.size()==0){
                ans.add(i);
            }
        }
        return ans;
    }
}