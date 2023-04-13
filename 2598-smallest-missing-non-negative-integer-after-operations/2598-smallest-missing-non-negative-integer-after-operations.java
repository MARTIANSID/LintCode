class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n=nums.length;
        int[] rem=new int[value];
        for(int ele:nums){
            // System.out.println(ele%value);
            rem[((ele%value)+value)%value]++;
        }
        for(int i=0;i<(int)1e7;i++){
            int req=((i%value)+value)%value;
            if(rem[req]>0){
                rem[req]--;
            }else{
                return i;
            }
        }
        return -1;
    }
}
