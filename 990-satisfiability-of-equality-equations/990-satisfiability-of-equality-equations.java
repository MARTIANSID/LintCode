class Solution {
    private int findParent(int u,int[] parent){
        if(parent[u]==u){
            return u;
        }
        int x=findParent(parent[u],parent);
        parent[u]=x;
        return x;
    }
    public boolean equationsPossible(String[] equations) {
        int n=equations.length;
        int[] parent=new int[26];
        
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        
        for(String eqn:equations){
            char a=eqn.charAt(0);
            char b=eqn.charAt(3);
            char sy1=eqn.charAt(1);
            char sy2=eqn.charAt(2);
            if(sy1=='='){
                int p1=findParent(a-'a',parent);
                int p2=findParent(b-'a',parent);
                if(p1!=p2){
                    parent[p1]=p2;
                }
            }
        }
        
        for(String eqn:equations){
            char a=eqn.charAt(0);
            char b=eqn.charAt(3);
            char sy1=eqn.charAt(1);
            char sy2=eqn.charAt(2);
            if(sy1=='!'){
                int p1=findParent(a-'a',parent);
                int p2=findParent(b-'a',parent);
                if(p1==p2){
                    return false;
                }
            }
        }
        return true;
        
    }
}