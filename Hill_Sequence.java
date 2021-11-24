
import java.util.*;
import java.io.*;

 class Hill_Sequence {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=0;
        if(br.ready())
            t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            Integer arr[] = new Integer[n];
            String line = br.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            boolean flag=false;
            int max=-(int)1e9;
            int maxFreq=0;
            System.out.println();
            for(int ele:arr){
                map.put(ele,map.getOrDefault(ele, 0)+1);
                if(map.get(ele)>=3){
                    System.out.print(-1);
                    flag=true;
                    break;
                }
                max=Math.max(max,ele);
                maxFreq=Math.max(maxFreq,map.get(ele));

            }
           
            if(flag){
                continue;
            }
                if(maxFreq==1){
                    Arrays.sort(arr,(a,b)->{
                        return b-a;
                    });
                    for(int ele:arr){
                        System.out.print(ele);
                        System.out.print(" ");
                    }

                    continue;
                }

                

            if(map.get(max)>=2){
                System.out.print(-1);
                continue;
            }
            

        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();


            

            for(int ele:arr){
                if(ele==max)continue;
                if(!map.containsKey(ele))continue;
                if(map.get(ele)>1){
                    left.add(ele);
                    right.add(ele);
                    map.remove(ele);
                }else{
                    right.add(ele);
                    map.remove(ele);

                }
            }
            Collections.sort(left,(a,b)->{
                return a-b;
            });
            Collections.sort(right,(a,b)->{
                return b-a;
            });
            for(int ele:left){
                System.out.print(ele);
                System.out.print(" ");
            }

            System.out.print(max+" ");
            for(int ele:right){
                System.out.print(ele);
                System.out.print(" ");
            }

        }
       
    }
}