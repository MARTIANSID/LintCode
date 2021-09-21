import java.util.*;

class Just_a_Graph {

    public static void main(String[] args) {

        Scanner sys = new Scanner(System.in);
        int t = 0;
        if (sys.hasNext()) {
            t = sys.nextInt();
        }

        while (t-- > 0) {
            int n = sys.nextInt();
          int[] w=new int[n+1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                w[i + 1] = sys.nextInt();
               
            }
           
            int[] parent=new int[n+1];

            for(int i=0;i<parent.length;i++){
                parent[i]=i;
            }

            for(int i=1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    if(j-i!=w[j]-w[i]){
                  

                        int p1=findParent(parent,i);
                        int p2=findParent(parent,j);
                        
                        if(p1!=p2){
                            parent[p1]=p2;
                        }
                    }
                }
            }

           

                HashMap<Integer,Integer> map=new HashMap<>();
                long comp=0;
            for(int i=1;i<parent.length;i++){
                int x=findParent(parent,i);
                if(!map.containsKey(x)){
                    comp++;
                    map.put(x,1);
                }
            }
            System.out.println(comp);

        }



    }

    public static int findParent(int[] parent,int u){
        if(parent[u]==u)return u;

        int x=findParent(parent,parent[u]);
        parent[u]=x;
        return x;
    }

   

}