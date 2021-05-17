class Solution {
        class pair{
                int capital;
                int profit;
                pair(int capital,int profit){
                        this.capital=capital;
                        this.profit=profit;
                }
        }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
            PriorityQueue<pair> pqProfit=new PriorityQueue<>((a,b)->{
                  return  b.profit-a.profit;
            });
            
            PriorityQueue<pair> pqCapital=new PriorityQueue<>((a,b)->{
                    return a.capital-b.capital;
            });
            
            int ans=w;
            
            for(int i=0;i<profits.length;i++){
                    pqCapital.add(new pair(capital[i],profits[i]));
            }
            
            
           while(k-->0){
                           while(pqCapital.size()>0&&pqCapital.peek().capital<=w){
                        pair p  = pqCapital.poll();
                           pqProfit.add(p);
                   }
                   
                   if(pqProfit.size()>0){
                          pair m= pqProfit.poll();
                           ans+=m.profit;
                                   // w-=m.capital;
                           w+=m.profit;
                   }else{
                           
                           break;
                   }
           }
            
            return ans;
           
            
            
            
            
       
           
        
    }
}