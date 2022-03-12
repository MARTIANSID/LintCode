class Solution { 
     class TrieNode{
        TrieNode[] children=new TrieNode[2];
        boolean isEnd=false;
    }
    
    class  Trie{
        TrieNode root;
        Trie(){
            this.root=new TrieNode();
        }
        
        public void insert(int no){
            TrieNode node=this.root;
            for(int i=31;i>=0;i--){
                int x=1<<i;
                int bit=(no&x)==0?0:1;
                if(node.children[bit]==null){
                    node.children[bit]=new TrieNode();
                }
                node=node.children[bit];
            }
            node.isEnd=true;
        }
        
        public int findMax(int no){
            TrieNode node=this.root;
            int ans=0;
            for(int i=31;i>=0;i--){
                int x=1<<i;
                int bit=(no&x)==0?0:1;
                int findBit=bit==0?1:0;
               
                if(node.children[findBit]!=null){
                    node=node.children[findBit];
                        ans+=(x);
                }else{
                    node=node.children[bit];
        
                }
            }
            
            return ans;
            
        }
    }
    public int findMaximumXOR(int[] arr) {
         Trie t=new Trie();
        for(int ele:arr){
            t.insert(ele);
        }
        int max=0;
        
        for(int ele:arr){
            int m=t.findMax(ele);
            max=Math.max(max,m);
        }
        return max;
    }
}