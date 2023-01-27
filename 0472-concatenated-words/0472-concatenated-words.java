import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isEnd = true;
        }

        public boolean check(String word, int index) {
            TrieNode node = root;
            
            for (int i = index; i < word.length(); i++) {
                char ch = word.charAt(i);
                
                if (node.children[ch - 'a'] == null) {
                    return false;
                }
                if(node.children[ch-'a'].isEnd){
                    if(check(word,i+1)){
                        return true;
                    }
                }
                node = node.children[ch - 'a'];
            }
            return node.isEnd;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(
            words,
            (a, b) -> {
                return a.length() - b.length();
            }
        );

        List<String> ans = new ArrayList<>();
        Trie t = new Trie();
        for (String str : words) {
            if (t.check(str,0)) ans.add(str);

            t.insert(str);
        }
        return ans;
    }
}
