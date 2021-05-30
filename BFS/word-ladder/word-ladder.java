class Solution {
        
        public boolean isSimilar(String s,String t){
                int count=0;
                for(int i=0;i<s.length();i++){
                        if(s.charAt(i)!=t.charAt(i)){
                                count++;
                        }
                }
                
                return count>1?false:true;
        }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> que=new LinkedList<>();
            
            HashMap<String,Integer> visited=new HashMap<>();
            que.add(beginWord);
            int level=1;
          while(que.size()!=0){
                  
         int size=que.size();
                  
                  while(size-->0){
                             String s=    que.removeFirst(); 
                          
                          if(s.equals(endWord))return level;
                          
                        for(int i=0;i<wordList.size();i++){
                                if(!visited.containsKey(wordList.get(i))&&isSimilar(s,wordList.get(i))){
                                        que.add(wordList.get(i));
                                        visited.put(wordList.get(i),1);
                                }
                        }  
                 
                  }
                  level++;
                  
                  
          }
            return 0;
    }
}