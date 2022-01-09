class Solution {
    
//     class Trie {
    
//     class TrieNode{
//         TrieNode[] children=new TrieNode[26];
//         boolean end=false;
    
//     } 
//         TrieNode root;
//         public Trie(){
//             root=new TrieNode();
//         }
        
//          public void insert(String word){
//             TrieNode node=this.root;
//             for(int i=0;i<word.length();i++){
//                 char c=word.charAt(i);
//                 if(node.children[c-'a']==null){
//                     node.children[c-'a']=new TrieNode();
//                 }
//                 node=node.children[c-'a'];
    
//             }
//             node.end=true;
//         }
        
//         public boolean startsWith(String word){
//             TrieNode node=root;
//             int[] freq=new int[26];
//             for(int i=0;i<word.length();i++){
               
//                 char c=word.charAt(i);
//                  freq[c-'a']++;
//                 if(node.children[c-'a']==null){
//                     return false;
//                 }
//                 node=node.children[c-'a'];
                
//             }
           
            
//                 return node.end;
            
//         }
//     }
    
    public int wordCount(String[] startWords, String[] targetWords) {
        int ans=0;
       
        
        
        HashMap<String,Integer> map=new HashMap<>();
        
        
        
            for(String t:targetWords){
                
           
        char[] chars = t.toCharArray();
                
        Arrays.sort(chars);
        String sorted = new String(chars);
            
             map.put(sorted,map.getOrDefault(sorted,0)+1);
        
    } 
        
        
        
        for(String s:startWords){
            String temp=s;
            //   char[] chars = temp.toCharArray();
            // Arrays.sort(chars);
            // String sorted = new String(chars);
            
            for(int i=0;i<26;i++){
                String h=temp+(char)(i+'a');
            char[] cha = h.toCharArray();
            Arrays.sort(cha);
            String st = new String(cha);
                if(map.containsKey(st)){
                    ans+=map.get(st);
                    map.remove(st);
                }
            }
             
        }
        return ans;
    }
}


