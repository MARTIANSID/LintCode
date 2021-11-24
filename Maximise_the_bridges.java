import java.util.*;

public class Maximise_the_bridges {
    public static void main(String[] args){
        Scanner sys=new Scanner(System.in);

        int t=0;
        if(sys.hasNext()){
            t=sys.nextInt();
        }
        while(t-->0){
            int v=sys.nextInt();
            int e=sys.nextInt();
                List<List<Integer>> graph=new ArrayList<>();
                for(int i=0;i<=v;i++)graph.add(new ArrayList<>());
                //forming a chain first
                for(int i=2;i<=v;i++){
                    graph.get(i-1).add(i);
                    graph.get(i).add(i-1);
                    e--;
                }
                
                int size=2,vrtx=2,src=1;
                while(e>0){
                    if(graph.get(vrtx).size()==size){
                        size++;
                        vrtx++;
                        src=1;
                    }else{
                        graph.get(vrtx).add(src);
                        graph.get(src).add(vrtx);
                        src++;
                        e--;
                    }
                }
               for(int i=1;i<=v;i++){
                   for(int j=0;j<graph.get(i).size();j++){
                       if(i<graph.get(i).get(j))
                       System.out.println((i)+" "+(graph.get(i).get(j)));
                   }
               }
            
        }
    }
}