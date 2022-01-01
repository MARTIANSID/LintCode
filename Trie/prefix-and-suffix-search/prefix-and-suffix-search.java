class WordFilter {

    class TrieNode{
        TrieNode[] children=new TrieNode[27];
        boolean isEnd=false;
        int index;
        
    }
    
    class Trie{
        TrieNode root;
        Trie(){
            root=new TrieNode();
        }
        
        public void insert(String word,int index){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                if(node.children[word.charAt(i)-'a']==null){
                    node.children[word.charAt(i)-'a']=new TrieNode();
                    
                    
                }
                node=node.children[word.charAt(i)-'a'];
                node.index=index;
            }
            node.isEnd=true;
            
        }
        
        
        public int search(String word){
            
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.children[ch-'a']==null)return -1;
                 node=  node.children[ch-'a'];
            }
            return node.index;
        }
        

        
    }
    
    Trie root; 
    
    public WordFilter(String[] words) {
        root=new Trie();
        
        for(int j=0;j<words.length;j++){
            String s=words[j];
            
            for(int i=0;i<=s.length();i++){
                root.insert(s.substring(i,s.length()) + '{' + s, j);
            }
        }
        
        
    }
    
    public int f(String prefix, String suffix) {
      return  root.search(suffix+'{'+prefix);
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */