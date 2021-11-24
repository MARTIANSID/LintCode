import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Wildcard_Replacement{
  static  class pair{
        int max;
        int min;
        pair(int max,int min){
            this.max=max;
            this.min=min;
        }
    }
  static pair [][] dp;
  static HashMap<String,pair> map=new HashMap<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sys=new Scanner(System.in);

        int t=0;
        if(br.ready())
        t=Integer.parseInt(br.readLine());

        while(t-->0){
           
           
            String s=br.readLine();
            int n=s.length();
           

            int l=Integer.parseInt(br.readLine());;
            int[][] q=new int[l][2];
            int index=0;
            while(l-->0){
                String line = br.readLine(); // to read multiple integers line
                String[] strs = line.trim().split("\\s+");
                
                for (int i = 0; i < strs.length; i++) {
                    q[index][i]= Integer.parseInt(strs[i]);
                }
                index++;
            }
            int[] arr=new int[n];
            points(s, arr);
            solve(s, 0, s.length()-1,arr);
            for(int i=0;i<q.length;i++){
                int start=q[i][0]-1;
                int end=q[i][1]-1;
                
                
                // if(dp[start][end]!=null)
                System.out.print(map.get(start+" "+end).max+" ");
                
            }
            System.out.println();
        }

    }


    public static void points(String s,int[] arr){
        int index=0;
        Stack<Integer> st=new Stack<>();
        st.push(index);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
                index=i;
            }else if(ch=='+'||ch=='-'){
                arr[index]=i;
            }else if(ch==')'){
                st.pop();
               index=st.peek();
            }
        }
    }


    public static  pair solve(String s,int si,int ei,int[] arr){
        String key=si+" "+ei;
        if(si==ei){
            pair p=new pair(1,0);
            // dp[si][ei]=p;
            map.put(key,p);
            
            return  p;
        }
       
        // map.put(key,)

        // if(dp[si][ei]!=null)return dp[si][ei];

        if(map.containsKey(key))return map.get(key);
        
        int max=-(int)1e9,min=(int)1e9;
     
            int i=arr[si];
            if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                pair left=solve(s,si+1,i-1,arr);
                pair right=solve(s,i+1,ei-1,arr);

                int m=-(int)1e9,mi=(int)1e9;
                if(s.charAt(i)=='+'){
                     m=left.max+right.max;
                     mi=right.min+left.min;
                }else if(s.charAt(i)=='-'){
                    m=left.max-right.min;
                    mi=left.min-right.max;
                }
               max=Math.max(m,max);
               min=Math.min(min,mi);

            }
        
        pair p=new pair(max,min);
        map.put(key,p);
        return  p;
    }
}