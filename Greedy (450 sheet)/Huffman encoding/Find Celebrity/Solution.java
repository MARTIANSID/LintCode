/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        /**
         * @param n a party with n people
         * @return the celebrity's label or -1
         */
        public int findCelebrity(int n) {
            // Write your code here
            Stack<Integer> st=new Stack<>();
            for(int i=0;i<n;i++){
                st.push(i);
            }
    
            while(st.size()!=1){
               int x= st.pop();
               int y=st.pop();
               if(knows(x,y)){
                   st.push(y);
               }else{
                   st.push(x);
               }
            }
            // System.out.println(st);
        int candidate=st.pop();
            for(int i=0;i<n;i++){
                if(i==candidate)continue;
                if(!knows(i,candidate)){
                    return -1;
                }
            }
    
            return candidate;
            
        }
    }
    
    
    // 1 2 3 4 5 6 7 8