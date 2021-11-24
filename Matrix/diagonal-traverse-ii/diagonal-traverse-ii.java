class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int n=nums.size();
        
        int m=0;
        
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        List<Integer> keys=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<nums.get(i).size();j++){
                 if(!map.containsKey(i+j)){
                     map.put(i+j,new ArrayList<>());
                     keys.add(i+j);
                 }
                map.get(i+j).add(nums.get(i).get(j));                
                m++;
            }
        }
        
    
        for(int i=0;i<keys.size();i++){
           List<Integer> arr= map.get(keys.get(i));
            Collections.reverse(arr);
            
        }
        
        
        // System.out.println(map);
        int j=0;
        int[] a=new int[m];
        for(int i=0;i<keys.size();i++){
           List<Integer> arr= map.get(keys.get(i));
            int size=arr.size();
            int k=0;
            while(size-->0){
                a[j++]=arr.get(k);
                k++;
            }
        }
        
        return a;
        
    }
}