import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dikstra {
    
    public static  class dijikstraPair {
        int vtx = 0;
        int wsf = 0;

        public dijikstraPair(int vtx, int wsf) {
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }

    public static int N=8;

    public  static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static ArrayList<Edge>[] graph = new ArrayList[N];
    public static void addEdge(int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }
    public static void constructGraph() {
        Scanner sys=new Scanner(System.in);

        System.out.println("Enter the total Nodes");
        N=sys.nextInt();

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

    System.out.println("Enter the total edges");
    int edg=sys.nextInt();

    for(int i=0;i<edg;i++){

        System.out.println("Enter Node 1");
        int u=sys.nextInt();

        System.out.println("Enter Node 2");
        int v=sys.nextInt();


        System.out.println("Enter Weight");
        int w=sys.nextInt();

        addEdge(u, v, w);
    }

      

    }
    public static void main(String[] args) throws Exception{

        constructGraph();

        for(int i=0;i<N;i++){
         System.out.println("Routing table for Node: "+ i);   
         dijikstra(i);

         System.out.println();
         System.out.println();

        }

    



    }

    public static void dijikstra(int src)  throws Exception{
        PriorityQueue<dijikstraPair> que = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });
      dijikstraPair srcc=  new dijikstraPair(src, 0);
        que.add(srcc);
      

        boolean[] vis = new boolean[N];
        while (que.size()>0) { 
            dijikstraPair p = que.remove();
            if (vis[p.vtx])
                continue; 
            if(src!=p.vtx)
            System.out.println("Distance of Node "+src+" to "+p.vtx +" is " +p.wsf);
            if (p.vtx != src)
               

            vis[p.vtx] = true;
            for (Edge e : graph[p.vtx]) {
                if (!vis[e.v]) {
                    que.add(new dijikstraPair(e.v, p.wsf + e.w));
                }
            }
        }
    }
}
