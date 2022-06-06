class Solution {
    TreeMap<Integer, Integer> tree;
    Random rand;
    int max = 0;

    public Solution(int[] w) {
        this.rand = new Random();
        this.tree = new TreeMap<>();
        List<int[]> arr=new ArrayList<>();
        int index=0;
        for(int ele:w){
            arr.add(new int[]{ele,index++});
        }
        Collections.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        int start = 0;
        for (int[] data :arr) {
            int ele=data[0];
            tree.put(ele + start, data[1]);
            start=ele+start;
            max =Math.max(max,start);
        }
        
      
    }

    public int pickIndex() {
        int n = rand.nextInt(max)+1;
        Integer val = tree.ceilingKey(n);
        System.out.println(val);
        return tree.get(val);
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
