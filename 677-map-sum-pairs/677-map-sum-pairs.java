class MapSum {
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        int val=0;
        
      
        
        public void add(int value){
            this.val+=value;
        }
        
        public void dec(int value){
            this.val-=value;
        }
    }
    
    HashMap<String,Integer> map;
    
    class Trie{
        TrieNode root;
        
        Trie(){
            this.root=new TrieNode();
        }
        
        
        public void insert(String key,int val,int remove){
            TrieNode node=this.root;
            for(int i=0;i<key.length();i++){
                char ch=key.charAt(i);
                if(node.children[ch-'a']==null){
                    node.children[ch-'a']=new TrieNode();
                }
                node.dec(remove);
                node.add(val);
                node=node.children[ch-'a'];
            }
            
            node.dec(remove);
            node.add(val);
        }
        
        
        public int prefixVal(String prefix){
            
             TrieNode node=this.root;
            for(int i=0;i<prefix.length();i++){
                char ch=prefix.charAt(i);
                if(node.children[ch-'a']==null){
                    return 0;
                }
                
                node=node.children[ch-'a'];
            }
            
            return node.val;
            
        }
        
        
    }

    
    Trie root;
    public MapSum() {
        this.map=new HashMap<>();
        this.root=new Trie();
    }
    
    public void insert(String key, int val) {
        
        
        int remove=map.getOrDefault(key,0);
        
        map.put(key,val);
        
        root.insert(key,val,remove);
    }
    
    public int sum(String prefix) {
        return root.prefixVal(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */