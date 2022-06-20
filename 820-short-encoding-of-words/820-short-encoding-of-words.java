class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isEnd = true;
        }

        public boolean contains(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    return false;
                }
                node = node.children[ch - 'a'];
            }
            return node.isEnd;
        }
      
    }

    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        Trie t = new Trie();
        Arrays.sort(
            words,
            (a, b) -> {
                return b.length() - a.length();
            }
        );
        int ans = 0;
        for (String w : words) {
            if (!t.contains(w)) {
                for (int i = 0; i < w.length(); i++) {
                    t.insert(w.substring(i, w.length()));
                }
                 ans += (w.length() + 1);
            } 
        }
        return ans;
    }
}
