public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
public int  findParent(int u,int[] parent){
    if(parent[u]==u){
        return u;
    }

   int x= findParent(parent[u],parent);
   parent[u]=x;
   return x;
}

    public boolean validTree(int n, int[][] edges) {
     
     int[] parent=new int[n];

     for(int i=0;i<parent.length;i++){
         parent[i]=i;
     }


     for(int i=0;i<edges.length;i++){

         int p1=findParent(edges[i][0],parent);
         int p2=findParent(edges[i][1],parent);

         if(p1!=p2){ 
                parent[p1]=p2;
         }else{
             return false;
         }

     }
     int count=0;
     for(int i=0;i<parent.length;i++){
         if(findParent(i ,parent)==i){
             count++;
            
         }
     }
     if(count>1)return false;

     return true;
    }
}