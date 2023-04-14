class Solution {

    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        while (true) {
            List<Integer> result=new ArrayList<>();
            Set<Integer> keys=map.keySet();
            for(int key:keys){
                if(map.get(key)==0)continue;
                result.add(key);
                map.put(key,map.get(key)-1);
            }
            if(result.size()==0)return ans;
            ans.add(result);
        }
    
    }
}
