class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int neg=0,ei=0,si=0,index=0;
        
        int[] ans=new int[n-k+1];
        
        while(ei<n){
            int no=nums[ei++];
            if(no<0)neg++;
            map.put(no,map.getOrDefault(no,0)+1);
        
            if(ei-si>k){
                no=nums[si++];
                if(no<0)neg--;
                map.put(no,map.get(no)-1);
                if(map.get(no)==0)map.remove(no);
            }
            if(ei-si == k){
                if(neg<x){
                    ans[index++]=0;
                }else{
                    int ele=0,a=0;
                    for(int i=-50;i<0;i++){
                        if(map.containsKey(i)){
                            ele+=map.get(i);
                            a=i;
                        }
                        if(ele >= x){
                            break;
                        }
                    }
                    ans[index++]=a;
                }
            }
        }
        return ans;
    }
}
