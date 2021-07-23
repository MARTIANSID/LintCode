class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //algo merge the lists
        //apply sliding window'
        List<int[]> sorted=new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                sorted.add(new int[]{i,nums.get(i).get(j)});
            }
        }
        Collections.sort(sorted,(a,b)->{
            return a[1]-b[1];
        });
        
        int ei=0,si=0,n=sorted.size(),count=nums.size();
        int[] freq=new int[count+1];
        int min=(int)1e9,start=0,end=0;
        // System.out.println(sorted.get(0)[0]);
        // System.out.println(count);
        
        while(ei<n){
            int[] p=sorted.get(ei++);
            if(freq[p[0]]++==0)count--;
            // System.out.println(count);
            while(si<ei&&count==0){
                if(sorted.get(ei-1)[1]-sorted.get(si)[1]<min){
                    min=sorted.get(ei-1)[1]-sorted.get(si)[1];
                    start=si;
                    end=ei-1;

                }
                        if(freq[sorted.get(si++)[0]]--==1)count++;
            }
            
        }
        
        return new int[]{sorted.get(start)[1],sorted.get(end)[1]};
        
    }
}


