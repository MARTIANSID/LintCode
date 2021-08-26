class Solution {
    //we will try to form every possible rectangle and find its area
    
    //
    
    public int minAreaRect(int[][] points) {
        int n=points.length;
        int m=points[0].length;
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            if(map.containsKey(x)){
                map.get(x).add(y);
            }else{
                HashSet<Integer> set=new HashSet<>();
                set.add(y);
                map.put(x,set);
            }
        }
        
        int min=(int)1e9;
        
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                
                //diagonal points
                if(x1!=x2&&y1!=y2){
                    
                    if(map.get(x1).contains(y2)&&map.get(x2).contains(y1)){
                        // we are sure that these points form a rectangle
                        //now we have to find the area of this rectangle
    
                         
                        min=Math.min(min,(Math.abs(x2-x1))*Math.abs(y2-y1));
                         
                      
                    }
                }
            }
        }
        
        return min==(int)1e9?0:min;
        
    }
}