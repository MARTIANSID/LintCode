class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            
            return a[1]-b[1];
            });
            
             List<int[]> tasks=new ArrayList<>();
        for(int i=0;i<n;i++){
            tasks.add(new int[]{arr[i],dep[i]});
        }
        Collections.sort(tasks,(a,b)->{
            return a[0]-b[0];
            });
            
            
            int stations=1;
            
                pq.add(new int[]{tasks.get(0)[0],tasks.get(0)[1]});
            
            for(int i=1;i<n;i++){
                if(pq.peek()[1]<tasks.get(i)[0]){
                  int[] p=  pq.poll();
                    pq.add(new int[]{p[0],Math.max(p[1],tasks.get(i)[1])});
                }else {
                    stations++;
                    pq.add(new int[]{tasks.get(i)[0],tasks.get(i)[1]});
                }
            }
            
            return stations;
        
        
        
    }
    
}
