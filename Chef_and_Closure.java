import java.util.*;

public class Chef_and_Closure{

    public int smallestRangeII(int[] nums, int k) {
        int n=nums.length;
        
        Arrays.sort(nums);
        
        
        for(int i=0;i<n;i++){
            
        }     
        
        return 0;
    }

    public static void main(String[] args){
        Scanner sys=new Scanner(System.in);
        int t=0;
        if(sys.hasNextInt())
         t=sys.nextInt();
        
        while(t-->0){
            int n=sys.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sys.nextInt();
            }
            int count=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]>1)count++;
            }

            if(count>1)System.out.println(0);
            else System.out.println(1);
        }

    }

}