import java.util.Arrays;
import java.util.Scanner;

public class Bellmanford {
   static  int[] dis = new int[5];
public static void main (String[] args){
Scanner sys=new Scanner(System.in);

    System.out.println("Enter the nodes");
    int vrtx=sys.nextInt();

    System.out.println("Enter the number of edges");
    int n=sys.nextInt();

dis=new int[vrtx];

int[][] edges=new int[n+1][3];

    for(int i=0;i<n;i++){
        System.out.println("Enter the node number");
        int u=sys.nextInt();
    
        System.out.println("Enter the destination node");
        int v=sys.nextInt();
    
        System.out.println("Enter weight");
        int w=sys.nextInt();
    
        edges[i][0]=u;
        edges[i][1]=v;
        edges[i][2]=w;
    
    }
        for(int i=0;i<vrtx;i++){
            bellmanFord(i, edges ,vrtx);

            System.out.println("Routing table for node:"+i);
            for(int j=0;j<dis.length;j++){
                System.out.println(dis[j]);
            }

        }
}   
    public static void bellmanFord(int src, int[][] edges, int N) {
       
        Arrays.fill(dis, (int) 1e9);
        dis[src] = 0;
        for (int EdgeCount = 1; EdgeCount <= N; EdgeCount++) {
            int[] ndis = new int[N];
            for (int i = 0; i < N; i++)
                ndis[i] = dis[i];

            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dis[u] != (int) 1e9 && dis[u] + w < ndis[v]) {
                    if (EdgeCount == N) {
                     
                        break;
                    }

                    ndis[v] = dis[u] + w;
                }
            }

            dis = ndis;
        }

    }
}
