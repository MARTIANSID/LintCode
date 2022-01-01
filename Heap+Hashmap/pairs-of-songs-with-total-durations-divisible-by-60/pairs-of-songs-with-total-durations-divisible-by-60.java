class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map=new HashMap<>();
        // Arrays.sort(time);
        int ans=0;
            for(int ele:time){
                int rem=ele%60;
                int want=(60-rem)%60;
                if(map.containsKey(want)){
                    ans+=map.get(want);
                   
                }
                map.put(rem,map.getOrDefault(rem,0)+1);      
                
            }
        return ans;
    }
}


// 60,120,180,240

// [30,20,150,100,40]
// 180
// 60
// 20,30,40,100,150    
