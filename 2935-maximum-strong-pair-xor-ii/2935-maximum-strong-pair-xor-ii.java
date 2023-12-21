class Solution {
    class TrieNode{
        TrieNode[] children= new TrieNode[2];
        int cnt=0;
    }
    class Trie{
        TrieNode root;
        Trie(){
            root=new TrieNode();
        }
        public void insert(int no){
            TrieNode node=root;
            
            for(int i=21;i>=0;i--){
                int x=(1<<i);
                int bit=(no&x) == 0 ? 0 : 1;
                if(node.children[bit] == null){
                    node.children[bit]=new TrieNode();
                }
                node.children[bit].cnt++;
                node=node.children[bit];
            }
        }
        public void delete(int no){
            TrieNode node=root;
            
            for(int i=21;i>=0;i--){
                int x=(1<<i);
                int bit=(no&x) == 0 ? 0 : 1;
                node.children[bit].cnt--;
                node=node.children[bit];
            }
        }
        public int findMax(int no){
             TrieNode node=root;
             int max=0;
            
            for(int i=21;i>=0;i--){
                int x=(1<<i);
                int bit=(no&x) == 0 ? 0 : 1;
                int reverseBit=1-bit;
                if(node.children[reverseBit] != null && node.children[reverseBit].cnt >0){
                    max+=Math.pow(2,i);
                    node=node.children[reverseBit];
                }else{
                    node=node.children[bit];
                }
            }
            return max;
        }
    }
    public int maximumStrongPairXor(int[] nums) {
        int n=nums.length;
        
        Trie t=new Trie();
        
        Arrays.sort(nums);
        
        int start=n-1,end=n-1,max=0;
        
        t.insert(nums[start]);
        
        while(start>=0){
        
            if(2*nums[start]>=nums[end]){
                max=Math.max(max,t.findMax(nums[start]));
                start--;
                if(start>=0){
                    t.insert(nums[start]);
                }
            }else{
                t.delete(nums[end]);
                end--;
            }
        }
        
        return max;
        
    }
}