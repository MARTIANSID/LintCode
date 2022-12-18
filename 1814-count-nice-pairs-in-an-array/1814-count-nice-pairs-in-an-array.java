import java.util.HashMap;

class Solution {
  int mod=(int)1e9+7;
  public int countNicePairs(int[] nums) {
    int n=nums.length;
    long cnt=0;
    HashMap<Integer,Long> map=new HashMap<>();

    for(int i=0;i<n;i++){
      int val=nums[i]-rev(nums[i]);
      if(map.containsKey(val)){
        cnt=(cnt+map.get(val))%mod;
      }
      map.put(val, map.getOrDefault(val, (long)0)+1);
    }
    return (int)(cnt%mod);
  }
  public int rev(int ele){
    int reversed=0;
    while(ele>0){
      int temp=ele%10;
      reversed=reversed*10+temp;
      ele/=10;
    }
    return reversed;
  }
}
