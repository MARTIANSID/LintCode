class Solution {

    class TrieNode {
        HashMap<String, TrieNode> map = new HashMap<>();
        boolean isEnd = false;
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                char first = ch;
                String c = "";
                while (i < word.length() && word.charAt(i) != '/') {
                    c += word.charAt(i);
                    i++;
                }
                if(c.length()==0)c+='/';
                
            
                if (!(node.map.containsKey(c))) {
                    node.map.put(c, new TrieNode());
                }
                node = node.map.get(c);
                // System.out.println(node.map);
            }
            node.isEnd = true;
        }

        public boolean contains(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                char first = ch;
                String c = "";
                 while (i < word.length() && word.charAt(i) != '/') {
                    c += word.charAt(i);
                    i++;
                }
                if(c.length()==0)c+='/';
                if (!(node.map.containsKey(c))) {
                    return false;
                } else if (node.map.get(c).isEnd) {
                    return true;
                }
                node = node.map.get(c);
            }
            return node.isEnd;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        Arrays.sort(folder,(a,b)->{
            return a.compareTo(b);
        });

        Trie t = new Trie();

        List<String> ans = new ArrayList<>();

        for (String f : folder) {
            if (!t.contains(f)) {
                ans.add(f);
                t.insert(f);
            }
        }
        return ans;
    }
}
