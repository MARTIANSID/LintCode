class Solution {
    class pair{
        int end;
        int roomno;
        pair(int end,int roomno){
            this.end=end;
            this.roomno=roomno;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        int m=meetings.length;
        //sorted meting on the basis on end time
        Arrays.sort(meetings,(a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        PriorityQueue<Integer> pqq=new PriorityQueue<>();
        for(int i=0;i<n;i++)pqq.add(i);
        int[] freq=new int[n];
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.end==b.end)return a.roomno-b.roomno;
            return a.end-b.end;
        });
        
        for(int[] meet:meetings){
            int s=meet[0],e=meet[1];
            while(pq.size()>0 && pq.peek().end<=s){
                pqq.add(pq.poll().roomno);
            }
            if(pq.size()==0 || pqq.size()>0){
                int rooms=pqq.poll();
                pq.add(new pair(e,rooms));
                freq[rooms]++;
            }else{
               pair p= pq.poll();
               freq[p.roomno]++;
               if(s<=p.end){
                   pq.add(new pair(p.end+(e-s),p.roomno));
               }else{
                   pq.add(new pair(e,p.roomno));
               }  
            }
        }
        
        // System.out.println(Arrays.toString(freq));
        
        int max=0,ans=0;
        
        for(int i=0;i<n;i++){
            if(max<freq[i]){
                max=freq[i];
                ans=i;
            }
        }
        return ans;
        
    }
}