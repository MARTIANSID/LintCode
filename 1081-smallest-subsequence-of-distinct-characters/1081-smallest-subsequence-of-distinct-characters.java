class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        boolean[] visited=new boolean[26];
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            
            map.put(ch,map.get(ch)-1); // decreasing the freqeuncy of this character
            if(map.get(ch)==0)map.remove(ch); //if it's count becomes zero remove it from the map
            
            if(visited[ch-'a'])continue;  //if it is already visited that means it is placed at a good position already
            
            while(st.size()>0 && st.peek()>ch && map.containsKey(st.peek())){
                visited[st.peek()-'a']=false;
                st.pop();
            }
            visited[ch-'a']=true;
            st.push(ch);
            
        }
        StringBuilder sb=new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop());
        }
        
        return new String(sb.reverse());
    }
}