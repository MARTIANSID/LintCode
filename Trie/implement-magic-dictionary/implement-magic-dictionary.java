class MagicDictionary {

    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd=false;
        
    }
    class Trie{
        TrieNode root;
        public Trie(){
            this.root=new TrieNode();
        }
        public void insert(String word){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.children[ch-'a']==null){
                    node.children[ch-'a']=new TrieNode();
                }
                node=node.children[ch-'a'];
            }
            node.isEnd=true;
        }
        
        public boolean search(String word,TrieNode node,int si){
       
            for(int i=si;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.children[ch-'a']==null)return false;
                node=node.children[ch-'a'];
            }
            if(!node.isEnd)return false;
            return true;
        }
        
        public boolean  magicSearch(String word,boolean isChanged,int si,TrieNode node){
 
             if(!isChanged&&si==word.length())return false;
            if(node==null)return false;
            
            for(int i=0;i<26;i++){
                char ch=word.charAt(si);
                    if(node.children[i]!=null&&(char)(i+'a')==ch){
                   boolean flag= magicSearch(word,false,si+1,node.children[i]);
                    if(flag)return true;
                    }
                
                if ((char)(i+'a')!=ch&&node.children[i]!=null){
                    if(si==word.length()-1&&node.children[i].isEnd)return true;
                  boolean flag=search(word,node.children[i],si+1);
                    if(flag)return true;
                }
                    
                }   
             return false;
            }
           
            
            
        }
    
    /** Initialize your data structure here. */
    Trie tree;
    public MagicDictionary() {
    tree=new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        
        for(int i=0;i<dictionary.length;i++){
            tree.insert(dictionary[i]);
        }
        
    }
    
    public boolean search(String searchWord) {
        
      // for(int j=0;j<searchWord.length();j++)
      //   for(int i=0;i<26;i++){
      //       char c=(char)(i+'a');
      //         char[] ch=searchWord.toCharArray();
      //       if(c!=ch[j]){
      //           ch[j]=c;
      //          if (tree.search(new String(ch)))return true;
      //       }
      //   }
        
      
        TrieNode node=tree.root;
        return tree.magicSearch(searchWord,false,0,node);
        
       
        
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */