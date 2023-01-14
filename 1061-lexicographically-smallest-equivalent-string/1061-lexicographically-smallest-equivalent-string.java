class Solution {
    public char findParent(char[] parent,char ch){
        if(parent[ch-'a'] == ch){
            return ch;
        }
        char x=findParent(parent,parent[ch-'a']);
        parent[ch-'a']=x;
        return x;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        char[] parent=new char[26];
        
        for(int i=0;i<26;i++){
            parent[i]=(char)(i+'a');
        }
        
        for(int i=0;i<s1.length();i++){
            char p1=findParent(parent,s1.charAt(i));
            char p2=findParent(parent,s2.charAt(i));
            if(p1!=p2){
                if(p1<p2){
                    parent[p2-'a']=p1;
                }else{
                    parent[p1-'a']=p2;
                }
            }
        }
        String ans="";
        for(int i=0;i<baseStr.length();i++){
            char p=findParent(parent,baseStr.charAt(i));
            ans+=p;
        }
        return ans;
    }
}