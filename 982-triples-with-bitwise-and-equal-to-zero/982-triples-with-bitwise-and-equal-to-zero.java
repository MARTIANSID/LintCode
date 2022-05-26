class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count=0;
        boolean isEnd = false;
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode node = root;
            for (int i = 16; i >= 0; i--) {
                int x = 1 << i;
                int bit = (num & x) == 0 ? 0 : 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
            node.isEnd = true;
            node.count++;
        }

    public int dfs(int num, int index, TrieNode node) {
        
            if (index == -1) {
                return node.count;
            }
    
            int x = 1 << index;
            int bit = (num & x) == 0 ? 0 : 1;
        
           
            int count = 0;

            if (bit == 1) {
                if(node.children[0]!=null)
                count += dfs(num, index - 1, node.children[0]);
            } else {
                if(node.children[0]!=null)
                count += dfs(num, index - 1, node.children[0]);
                if(node.children[1]!=null)
                count += dfs(num, index - 1, node.children[1]);
            }
            return count;
        }
    }

    public int countTriplets(int[] nums) {
        int n = nums.length;

        Trie t = new Trie();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t.insert((nums[i] & nums[j]));
            }
        }
        
        int ans = 0;
        for (int ele : nums) {
            TrieNode node = t.root;
            ans+= t.dfs(ele,16, node);
            
        }

        return ans;
    }
}
