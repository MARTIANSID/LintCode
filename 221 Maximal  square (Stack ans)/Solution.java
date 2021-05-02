class Solution {
    public int maximalSquare(char[][] matrix) {
        
            
               if(matrix.length==0)return 0;
            
            int[] prefix=new int[matrix[0].length];
            
            int max=0;
            
            for(int i=0;i<matrix.length;i++){
                    for(int j=0;j<matrix[0].length;j++){
                            if(matrix[i][j]=='1'){
                                    prefix[j]+=1;
                            }else{
                                    prefix[j]=0;
                            }
                            
                           
                    }
        max= Math.max(max,largestRectangleArea(prefix));
            }
            return max;
            
    }
        
        
        
        
        
        public int largestRectangleArea(int[] heights) {
     
        
           int[] left=leftSmaller(heights);
           int[] right=rightSmaller(heights);
            
            int max=0;
            for(int i=0;i<heights.length;i++){
                   int x= Math.min((right[i]-left[i]-1),heights[i]);
                    max=Math.max(max,x*x);
            }
            
            return max;
        
    
            
    }
        
        public int[]  leftSmaller(int[] heights){
                
                int[] smaller=new int[heights.length];
                Arrays.fill(smaller,-1);
                
                Stack<Integer> st=new Stack<>();
                
                for(int i=0;i<heights.length;i++){
                        
                        while(st.size()>0){
                                if(heights[st.peek()]<heights[i]){
                                        smaller[i]=st.peek();
                                        break;
                                }
                                st.pop();
                        }
                        st.push(i);
                        
                }
                
                
                
                return smaller;
                        
        }
        
        public int[] rightSmaller(int[] heights){
                  int[] smaller=new int[heights.length];
                Arrays.fill(smaller,heights.length);
                
                Stack<Integer> st=new Stack<>();
                
                for(int i=heights.length-1;i>=0;i--){
                        
                        while(st.size()>0){
                                if(heights[st.peek()]<heights[i]){
                                        smaller[i]=st.peek();
                                        break;
                                }
                                st.pop();
                        }
                        st.push(i);
                        
                }
                
                
                
                return smaller;
                        
        }
}