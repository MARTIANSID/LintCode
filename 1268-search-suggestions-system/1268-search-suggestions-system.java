class Solution {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    
    class Trie {
        
        TrieNode root;
        
        public Trie() {
            this.root = new TrieNode();
        }
        
        public void insert(String word){
            TrieNode node = root;
            
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                
                if(node.children[ch-'a'] == null){
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isEnd = true;
        }
        
        public List<String> checkPrefix(String prefix){
            TrieNode node = root;
            
            for(int i = 0; i < prefix.length(); i++){
                char ch = prefix.charAt(i);
                
                if(node.children[ch-'a'] == null){
                    return new ArrayList<>();
                }
                node = node.children[ch - 'a'];
            }
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            findWords(node,result,sb,prefix);
            
            return result;
        }
        
        private void findWords(TrieNode node, List<String> result,StringBuilder sb, String prefix){
            
            if(node.isEnd){
                result.add(sb.toString());
            }
            
            if(result.size() == 3) return;
            
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    sb.append((char)(i+'a'));
                    findWords(node.children[i],result,sb,prefix);
                    
                    if(result.size() == 3){
                        return;
                    }
                    
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        
        Trie t = new Trie();
        
        for(String word: products){
            t.insert(word);
        }
        String prefix = "";
        for(int i = 0; i < searchWord.length(); i++){
            prefix += searchWord.charAt(i);
            
            ans.add(t.checkPrefix(prefix));
            
        }
        return ans;
    }
}




//


// for word in words:
//     t.insert(word) // insert in trie O(n^2)

        
// for ch in searchWord:
//     prefix+=ch
//     ans.add(findWords(prefix))  O(n*n*26*3)
        

        
// def findWords(prefix):
//     node = check(prefixExsist)
        
//     for i in range(0,26):
//         if node.children[i] != null:

    