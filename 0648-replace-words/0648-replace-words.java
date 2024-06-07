class Solution {
    
      class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd = false;
    }
    
    
    class Trie {
        TrieNode root;
        
        Trie(){
            this.root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root; 
            
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                
                if(node.children[ch-'a'] == null) {
                    node.children[ch-'a'] = new TrieNode();
                   
                }
                
                node = node.children[ch - 'a'];
               
            }
            
           node.isEnd = true;
        }
        
        public String findRoot(String word) {
            TrieNode node = root; 
            
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                
                if(node.children[ch-'a'] == null) {
                    return word;
                   
                }
                
                if(node.children[ch-'a'].isEnd) return word.substring(0,i+1);
                
                node = node.children[ch - 'a'];
            }
            return word;
        }
    }
        
    public String replaceWords(List<String> dictionary, String sentence) {
        int n = dictionary.size(), index = 0;
        
        Trie t  = new Trie();
        
        for(String word : dictionary) {
            t.insert(word);
        }
        
        StringBuilder sb = new StringBuilder();
        
        String[] words = sentence.split(" ");
        
        for(String word : words) {
            String root = t.findRoot(word);
            
            if(index < words.length - 1)
            sb.append(root+" ");
            else
            sb.append(root);
            
            index++;
            
        }
        return sb.toString();
    }
}