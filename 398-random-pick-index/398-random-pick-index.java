class Solution {
    Random rand;
    HashMap<Integer,List<Integer>> map;
    public Solution(int[] nums) {
        this.rand=new Random();
        this.map=new HashMap<>();
        int n=nums.length;
        int index=0;
        for(int ele:nums){
            map.putIfAbsent(ele,new ArrayList<>());
            map.get(ele).add(index++);
        }
    }
    
    public int pick(int target) {
        List<Integer> arr=map.get(target);
        int random=rand.nextInt(arr.size());
        return arr.get(random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */