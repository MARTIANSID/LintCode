class Solution {
    
    String ans ="";
    class Trie {
    
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean end=false;
    
    }
    
        /** Initialize your data structure here. */
       
        TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        
        
        /** Inserts a word into the trie. */
         public void insert(String word){
            TrieNode node=this.root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode();
                }
                node=node.children[c-'a'];
    
            }
            node.end=true;
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public String s(String word){
            
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                ans+=c;
                if(node.children[c-'a']==null){
                    return "";
                }
                if(node.end)return ans;
                node=node.children[c-'a'];
                if(node.end)return ans;
            }
            return "";
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        int n=dictionary.size();
        Trie root=new Trie();
        for(int i=0;i<n;i++)root.insert(dictionary.get(i));
        String[] words=sentence.split(" ");
        String aa ="";
        for(int i=0;i<words.length;i++){
          String val=  root.s(words[i]);
            if(!val.equals("")){
                words[i]=ans;
            }
            ans="";
        }
        for(int i=0;i<words.length;i++){
            aa+=words[i];
            if(i!=words.length-1)aa+=" ";
        }
        
        return aa;
        
    }
}