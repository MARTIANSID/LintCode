class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,-1);
        int currSum=0;
        int min=(int)1e9;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
           Integer num= map.floorKey((currSum-k));
            // System.out.println(num);
            while(num!=null){
                int x=map.get(num);
                min=Math.min(min,i-x);
                map.remove(num);
                num=map.lowerKey(num);
                
            }
            if(map.containsKey(currSum)){
                map.put(currSum,Math.max(i,map.get(currSum)));
            }else{
                map.put(currSum,i);
            }
        }
        
        return min==(int)1e9?-1:min;
        
    }
}


// [56,-21,56,35,-9]
// 56
// 35
// 91
// 126

