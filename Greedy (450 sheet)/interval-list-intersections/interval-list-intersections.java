class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int n=firstList.length;
        int m=secondList.length;
        
        List<List<Integer>> ans=new ArrayList<>();
        
        int i=0,j=0;
        
            while(i<n&&j<m){
                List<Integer> a=new ArrayList<>();
                int min=(int)1e9,max=-(int)1e9;
                
                if(i<n&&firstList[i][1]<secondList[j][0]){
                    i++;
                    continue;
                }
                if(j<m&&firstList[i][0]>secondList[j][1]){
                    j++;
                    continue;
                }
               
                
                
                
                
                if(firstList[i][1]>secondList[j][1]){
                    max=Math.max(firstList[i][0],secondList[j][0]);
                    min=secondList[j][1];
                               j++; 
                }else if(firstList[i][1]<secondList[j][1]){
                    max=Math.max(firstList[i][0],secondList[j][0]);
                    min=firstList[i][1];
                    i++;
                    
                }else{
                     max=Math.max(firstList[i][0],secondList[j][0]);
                        min=firstList[i][1];
                    i++;
                    j++;    
                }
        a.add(max);
        a.add(min);
                 ans.add(a);
            }
        

       
         int s1=ans.size();
        int s2=0;
        if(ans.size()>0)
        s2=ans.get(0).size();
       
        int[][] result=new int[s1][s2];
    
        for(i=0;i<s1;i++){
            for(j=0;j<s2;j++){
                result[i][j]=ans.get(i).get(j);
            }
        }
        return result;
        
    
       
    }
}