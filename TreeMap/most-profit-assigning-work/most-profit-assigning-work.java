class Solution {
    
    class pair{
        int difficulty;
        int profit;
        pair(int difficulty,int profit){
            this.difficulty=difficulty;
            this.profit=profit;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer,Integer> tree=new TreeMap<>();
      List<pair> prop=new ArrayList<>();
        for(int i=0;i<difficulty.length;i++){
            prop.add(new pair(difficulty[i],profit[i]));
           
        }
        
        Collections.sort(prop,(a,b)->{
            if(a.difficulty==b.difficulty){
                return b.profit-a.profit;
            }else{
               return a.difficulty-b.difficulty;
            }
        });
        
        int[] poss=new int[profit.length];
        
        int max=0;
        for(int i=0;i<prop.size();i++){
            
             tree.put(prop.get(i).difficulty,i);
            // System.out.println(prop.get(i).difficulty);
          max=Math.max(max,prop.get(i).profit);
            poss[i]=max;
            // System.out.println(max);
        }
        
        
        
        
        int ans=0;
        for(int i=0;i<worker.length;i++){
  Integer x=   tree.floorKey(worker[i]);
            //   if(x!=null)
            // System.out.println(tree.get(x));
            // if(x!=null)
            // System.out.println(poss[tree.get(x)]);
        ans+=x==null?0:poss[tree.get(x)];
        }
        
        return ans;
    }
}