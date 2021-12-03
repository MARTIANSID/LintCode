class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n=nums.length;
        
        HashMap<Integer,TreeSet<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                TreeSet<Integer> set=new TreeSet<>();
                set.add(i);
                map.put(nums[i],set);
            }else{
                map.get(nums[i]).add(i);
            }
        }
        int[] ans=new int[queries.length];
        
        int index=0;
        for(int[] q:queries){
            int start=q[0];
            int end=q[1];
            TreeSet<Integer> set=new TreeSet<>();
            int min=(int)1e9;
            for(int i=1;i<=100;i++){
                if(map.containsKey(i)){
                    TreeSet<Integer> s=map.get(i);
                    if((s.ceiling(start)!=null&&s.ceiling(start)<=end)||(s.floor(end)!=null&&s.floor(end)>=start)){
                         Integer k= set.lower(i);
                    // System.out.println(k);
                    if(k!=null){
                        min=Math.min(min,Math.abs(k-i));
                    }
                    k=set.higher(i);
                    if(k!=null){
                        min=Math.min(min,Math.abs(k-i));
                    }
                        // System.out.println(min);

                    set.add(i);
                    }
                  
                }
            }
          
            ans[index]= min==(int)1e9?-1:min;
            index++;
        }
        
        return ans;
    }
}