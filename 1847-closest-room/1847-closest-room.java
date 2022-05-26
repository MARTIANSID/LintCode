class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
  
        int m=queries.length;
        
        int[][] q=new int[m][3];
        
        for(int i=0;i<m;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }
        
        Arrays.sort(q,(a,b)->{
            return b[1]-a[1];
        });
        
         int n=rooms.length;
         int[][] room=new int[n][3];
        
        for(int i=0;i<n;i++){
            room[i][0]=rooms[i][0];
            room[i][1]=rooms[i][1];
            room[i][2]=i;
            
        }
        
        Arrays.sort(room,(a,b)->{
           return b[1]-a[1];
        });
        
        
        
       
        TreeMap<Integer,Integer> tree=new TreeMap<>();
        
        int index=0;
        
        int queryNo=0;
        
        int[] ans=new int[queries.length];
        
        
        for(int[] query:q){
            int preferredId=query[0],minSize=query[1];
            
            if(tree.size() == 0 && index<n && room[index][1]<minSize){
                // -1 
                ans[query[2]]=-1;
            }else{
                while(index<n && room[index][1]>=minSize){
                    tree.put(room[index][0],room[index][2]);
                    index++;
                }
                //get floorKey
                //get ceilingKey
               Integer floor= tree.floorKey(preferredId);
               Integer ceil=tree.ceilingKey(preferredId);
                
                int diff1=(int)1e9;
                if(floor!=null){
                    diff1=Math.abs(floor-preferredId);
                    ans[query[2]]=floor;
                }
                
                int diff2=(int)1e9;
                if(ceil!=null){
                    diff2=Math.abs(ceil-preferredId);
                    if(diff2<diff1){
                        ans[query[2]]=ceil;
                    }
                }
               
                
            }
        }
        
        return ans;
        
    }
}