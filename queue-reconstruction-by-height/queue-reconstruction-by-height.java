class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(b[0]==a[0])return a[1]-b[1];
            return b[0]-a[0] ;
        });   
        
      
    List<int[]> a=new ArrayList<>();
        
        for(int  i=0;i<people.length;i++){
         int index=people[i][1];  
            if(index>=a.size()){
            a.add(new int[]{people[i][0],people[i][1]});
            }else{
                int[] val=a.get(index);
                a.set(index,new int[]{people[i][0],people[i][1]});
                index++;
                while(index<=a.size()){
                    if(index==a.size()){
                        a.add(new int[]{val[0],val[1]});
                        break;
                    }else {
                        int[] x=a.get(index);
                        a.set(index,new int[]{val[0],val[1]});
                        val=new int[2];
                        for(int j=0;j<x.length;j++)val[j]=x[j];
                    }
                    index++;
                }
            }
        }
        
        int[][] ans=new int[people.length][2];
        for(int i=0;i<ans.length;i++){
            ans[i]=new int[]{a.get(i)[0],a.get(i)[1]};
        }
          
        return ans;
    }
}