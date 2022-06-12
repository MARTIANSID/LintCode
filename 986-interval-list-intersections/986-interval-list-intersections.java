class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n=firstList.length;
        int m=secondList.length;
        
        int i=0,j=0;
        
        List<int[]> list=new ArrayList<>();
        
        while(i<n &&j<m){
              if(i==n || j==m)break;
            if(firstList[i][1]<secondList[j][0]){
                 i++;
                continue;
                                                  }
            if(secondList[j][1]<firstList[i][0]){
                j++;
                continue;
            }
            
          

            if(firstList[i][1]<=secondList[j][1]){
                int l=Math.max(firstList[i][0],secondList[j][0]);
                list.add(new int[]{l,firstList[i][1]});
                i++;
            }else{
                int l=Math.max(firstList[i][0],secondList[j][0]);
                list.add(new int[]{l,secondList[j][1]});
                j++;
            }
            
        }
        int[][] ans=new int[list.size()][2];
        int index=0;
        for(int[] data:list){
            ans[index++]=data;
        }
        return ans;
    }
}