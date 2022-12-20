import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;
class Solution {

  public String largestNumber(int[] nums) {
    int n=nums.length;
    Integer[] arr=new Integer[n];
    for(int i=0;i<n;i++){
      arr[i]=nums[i];
    }
    Arrays.sort(arr,(a,b)->{
        String x=a+""+b;
        String y=b+""+a;
        return y.compareTo(x);
    });
    if(arr[0]==0)return "0";

    StringBuilder ans=new StringBuilder();
    for(int ele:arr){
      ans.append(ele+"");
    }
    // System.out.println(ans);
    return new String(ans);

  }
}