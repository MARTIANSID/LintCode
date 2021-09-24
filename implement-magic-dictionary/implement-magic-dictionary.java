class MagicDictionary {

    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd=false;
        
    }
    class Trie{
        TrieNode root;
        public Trie(){
            this.root=new TrieNode();
        }
        public void insert(String word){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.children[ch-'a']==null){
                    node.children[ch-'a']=new TrieNode();
                }
                node=node.children[ch-'a'];
            }
            node.isEnd=true;
        }
        
        public boolean search(String word){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.children[ch-'a']==null)return false;
                node=node.children[ch-'a'];
            }
            if(!node.isEnd)return false;
            return true;
        }
    }
    /** Initialize your data structure here. */
    Trie tree;
    public MagicDictionary() {
    tree=new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        
        for(int i=0;i<dictionary.length;i++){
            tree.insert(dictionary[i]);
        }
        
    }
    
    public boolean search(String searchWord) {
        
      for(int j=0;j<searchWord.length();j++)
        for(int i=0;i<26;i++){
            char c=(char)(i+'a');
              char[] ch=searchWord.toCharArray();
            if(c!=ch[j]){
                ch[j]=c;
               if (tree.search(new String(ch)))return true;
            }
        }
        
        return false;
        
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */