class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st=new Stack<>();
            
        for(int i=0;i<nums.length;i++){
                if(st.size()>0){
                        
                        if(st.peek()>0&&nums[i]<0){
                                
                            while(st.size()>0&&-nums[i]>st.peek()&&st.peek()>0)st.pop();
                                
                             if(st.size()>0&&-nums[i]>st.peek()&&st.peek()>0){
                                     st.pop();
                                     st.push(nums[i]);
                                     continue;
                             }  else if(st.size()>0&&-nums[i]==st.peek()){
                                     st.pop();
                                     continue;
                             } 
                                if(st.size()==0||st.size()>0&&st.peek()<0)
                                st.push(nums[i]);
                                
                        } else if(nums[i]<0&&-nums[i]==st.peek()){
                                st.pop();
                        }
                        else{
                                st.push(nums[i]);
                        }
                        
                }else{
                        st.push(nums[i]);
                }
        }
            int[] ans=new int[st.size()];
            
            for(int i=0;i<ans.length;i++){
                    ans[i]=st.get(i);
            }
            return ans;
    }
}