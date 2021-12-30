class Solution {
    
    
    public static List<String> ans=new ArrayList<>();
    
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd =false;
    }
    
    
    class Trie{
        TrieNode root;
        Trie(){
            this.root=new TrieNode();
        }
        
        public void insert(String word){
                TrieNode node=root;
            for(int i=0;i<word.length();i++){
                if(node.children[word.charAt(i)-'a']==null){
                    node.children[word.charAt(i)-'a']=new TrieNode();
                }
                node=node.children[word.charAt(i)-'a'];
            }
            node.isEnd=true;
        }
        
        public TrieNode prefix(String str){
             TrieNode node=root;
            for(int i=0;i<str.length();i++){
                if(node.children[str.charAt(i)-'a']==null)return null;
                 node=node.children[str.charAt(i)-'a'];
            }
           
            
             return node;
        }
    
    
    
    public int find(TrieNode node,String sub,String end){
        
         int count=0;
        if(node.isEnd){
            if(ans.size()==3)return 3;
            ans.add(sub+end);
             count++;
        }
        
        if(count>=3)return 3;
        
       
        for(int i=0;i<26;i++){
            
            if(node.children[i]!=null){
               count+= find(node.children[i],sub,end+(char)(i+'a'));
                if(count>=3)return 3;
            }
        }
        
        return count;
        
        
    }
    
    }
    
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Trie t=new Trie();
        
        for(String str:products){
            t.insert(str);
        }
        
        String s="";
        
        
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            s+=searchWord.charAt(i);
           TrieNode n= t.prefix(s);
            if(n==null){
                
            }else{
                t.find(n,s,"");
            }
            
            List<String> temp=new ArrayList<>();
            for(String a:ans){
                temp.add(a);
            }
            result.add(temp);
            ans=new ArrayList<>();
            
        }
        
        return result;
        
    }
}