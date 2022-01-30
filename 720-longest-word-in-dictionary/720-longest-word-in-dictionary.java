class Solution {
    
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd=false;
    }
    
    class Trie{
        
        TrieNode root;
        
        Trie(){
            this.root=new TrieNode();
        }
        
        
        public String insert(String word){
            TrieNode node=root;
            String s="";
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
               
                if(node.children[ch-'a']==null){
                    if(i==word.length()-1){
                        node.children[ch-'a']=new TrieNode();
                        s+=ch;
                    }
                    
                    return s;
                }
                 s+=ch;
                node=node.children[ch-'a'];
            }
            return s;
        }
        
        
    }
    
    public String longestWord(String[] words) {
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        
        Trie t=new Trie();
        
        int max=0;
        String ans="z";
        
        for(String w:words){
           String ss= t.insert(w);
            if(ss.length()>max){
                max=ss.length();
                    ans=ss;
            }else if(ss.length()==max){
                if(ss.compareTo(ans)<0){
                    ans=ss;
                }
            }
        }
        return ans;
        
    }
}