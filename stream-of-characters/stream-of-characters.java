class StreamChecker {
       
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
            for(int i=word.length()-1;i>=0;i--){
                char c=word.charAt(i);
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode();
                }
                node=node.children[c-'a'];
    
            }
            node.end=true;
        }
        
        /** Returns if the word is in the trie. */
       public boolean search(String word){
            TrieNode node=root;
            for(int i=word.length()-1;i>=0;i--){
                char c=word.charAt(i);
                if(node.children[c-'a']==null){
                    return false;
                }
                if(node.end)return true ;
                node=node.children[c-'a'];
                        if(node.end)return true ;

                
            }
            return node.end;
        }
     
    }

    Trie root=new Trie();
    String suffix="";
    public StreamChecker(String[] words) {
         for (int i=0;i<words.length;i++){
             root.insert(words[i]);
         }
    }
    
    public boolean query(char letter) {
        suffix+=letter;
            if(root.search(suffix))return true;
        return false;
        
    }
}



/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */