import java.util.*;
class Solution {
  public long[] distance(int[] nums) {
      int n=nums.length;
      HashMap<Integer,Long> freq=new HashMap<>();
      HashMap<Integer,Long> sum=new HashMap<>();
      Set<Integer> set=new HashSet<Integer>();
      HashMap<Integer,Long> left=new HashMap<>();
      HashMap<Integer,Long> right=new HashMap<>();
      HashMap<Integer,Long> fLeft=new HashMap<>();
      HashMap<Integer,Long> fRight=new HashMap<>();


      for(int i=0;i<n;i++){
        if(set.contains(nums[i]))
        left.put(i,sum.get(nums[i]));
        fLeft.put(i,freq.get(nums[i]));
        freq.put(nums[i],freq.getOrDefault(nums[i],(long)0)+1);
        sum.put(nums[i],sum.getOrDefault(nums[i],(long)0)+i);
        set.add(nums[i]);
      }
      set=new HashSet<>();
      freq=new HashMap<>();
      sum=new HashMap<>();

      for(int i=n-1;i>=0;i--){
          if(set.contains(nums[i]))
          right.put(i,sum.get(nums[i]));
          fRight.put(i,freq.get(nums[i]));
          freq.put(nums[i],freq.getOrDefault(nums[i],(long)0)+1);
          sum.put(nums[i],sum.getOrDefault(nums[i],(long)0)+i);
          set.add(nums[i]);
      }
      long[] ans=new long[n];
      
  

      for(int i=0;i<n;i++){
        long result=0;
        if(left.containsKey(i)){
          result+=(fLeft.get(i)*i-left.get(i));
        }
      
        if(right.containsKey(i)){
          result+=right.get(i)-fRight.get(i)*i;
        }
        ans[i]=result;
      }
      return ans;
  }
}