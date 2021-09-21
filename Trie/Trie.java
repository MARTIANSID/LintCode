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
        
        /** Returns if the word is in the trie. */
       public boolean search(String word){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(node.children[c-'a']==null){
                    return false;
                }
                node=node.children[c-'a'];
                
            }
            return node.end;
        }
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String word){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(node.children[c-'a']==null){
                    return false;
                }
                node=node.children[c-'a'];
                
            }
            return true;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */