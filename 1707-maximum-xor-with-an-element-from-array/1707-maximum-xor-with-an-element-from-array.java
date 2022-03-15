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
            int v=0;
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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie t=new Trie();
      
        Arrays.sort(nums);
        
        
        int[][] qs=new int[queries.length][3];
        
        int i=0;
        for(int[] q:queries){
            int[] temp=new int[3];
            temp[0]=q[0];
            temp[1]=q[1];
            temp[2]=i;
            qs[i]=temp;
            i++;
        }
        
        
        Arrays.sort(qs,(a,b)->{
           return  a[1]-b[1];
        });
        
        int[] ans=new int[queries.length];
        
        
        
        int index=0;
        for(int[] q:qs){
            int m=q[1];
            while(index<nums.length  && nums[index]<=m){
                t.insert(nums[index]);
                index++;
            }
            if(index!=0)
            ans[q[2]]=t.findMax(q[0]);
            else
            ans[q[2]]=-1;
        }
      
        return ans;
    }
}