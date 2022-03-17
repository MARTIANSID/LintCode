class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb=new StringBuilder(s);
        int total=0;
        if(x>y){
            total+=remove(sb,true,x);
            total+=remove(sb,false,y);
        }else{
            total+=remove(sb,false,y);
            // System.out.println(sb);
            total+=remove(sb,true,x);
        }
        return total;
    }
    public int remove(StringBuilder sb,boolean flag,int val){
        
        int points=0;
        
        Stack<Integer> st=new Stack<>();
        List<Integer> indexes=new ArrayList<>();
        
        if(flag){
            //remove x
            for(int i=0;i<sb.length();i++){
                if(st.size()>0 && sb.charAt(st.peek())=='a' && sb.charAt(i)=='b'){
                    int index=st.pop();
                    indexes.add(index);
                    indexes.add(i);
                    points+=val;
                }else{
                    st.push(i);
                }
            }
        }else{
            //remove y
             for(int i=0;i<sb.length();i++){
                if(st.size()>0 && sb.charAt(st.peek())=='b' && sb.charAt(i)=='a'){
                    int index=st.pop();
                    indexes.add(index);
                    indexes.add(i);
                    points+=val;
                }else{
                    st.push(i);
                }
            }
        }
        Collections.sort(indexes);
        for(int i=indexes.size()-1;i>=0;i--){
            sb.deleteCharAt(indexes.get(i));
        }
        return points;
    }
}