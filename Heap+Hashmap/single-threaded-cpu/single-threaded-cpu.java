class Solution {
    class pair{
        int time;
        int index;
        pair(int time,int index){
            this.time=time;
            this.index=index;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.time==b.time)return a.index-b.index;
            return a.time-b.time;
        });
        int[][] t=new int[n][3];
        
        int i=0;
        for(int[] k:tasks){
            t[i][0]=k[0];
            t[i][1]=k[1];
            t[i][2]=i;
            i++;
        }
        
        Arrays.sort(t,(a,b)->{
            return a[0]-b[0];
        });
        
        int time=0,index=0;
        i=0;
        int[] ans=new int[n];
        while(pq.size()>0||index<n){
            while(index<n&&t[index][0]<=time){
                pq.add(new pair(t[index][1],t[index][2]));
                index++;
            }
            
            if(pq.size()!=0){
            ans[i]=pq.peek().index;
               time+= pq.poll().time;
                i++;
            
            }else{
                if (index<n){
                    time=t[index][0];
                    while(index<n&&t[index][0]<=time){
                pq.add(new pair(t[index][1],t[index][2]));
                index++;
            }
                     ans[i]=pq.peek().index;
               time+= pq.poll().time;
                i++;
                    
                }
                
            }
        }
        return ans;
        
    }
}