class Solution {
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd;
    }
    
    Integer[] dp;
    
    class Trie{
        TrieNode root;
        
        Trie(){
            this.root=new TrieNode();
        }
        
        public void add(String s){
            TrieNode node=this.root;
            
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                
                if(node.children[ch-'a'] == null){
                    node.children[ch-'a']=new TrieNode();
                }
                node=node.children[ch-'a'];
            }
            node.isEnd=true;
        }
        
        public boolean contains(String s){
             TrieNode node=this.root;
            
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                
                if(node.children[ch-'a'] == null){
                    return false;
                }
                node=node.children[ch-'a'];
            }
            if(node.isEnd){
                return true;
            }
          return false;
        }
       
    }
    
    public int dfs(String s,Trie t,int index){
        
        if(index == s.length()){
            return 0;
        }
        
        if(dp[index]!=null)return dp[index];
        
        int take=(int)1e9;
        for(int i=index;i<s.length();i++){
            String str=s.substring(index,i+1);
            if(t.contains(str)){
                take=Math.min(take,dfs(s,t,i+1));
            }
        }
        int leave=dfs(s,t,index+1)+1;
        
        return dp[index]=Math.min(take,leave);
    }
    
    
    public int minExtraChar(String s, String[] dictionary) {
        int n=dictionary.length;
        
        Trie t=new Trie();
        
        dp=new Integer[s.length()+1];
        
        for(String str:dictionary){
            t.add(str);    //adding words in trie
        } 
        
   
        return dfs(s,t,0);
        
        
    }
}




