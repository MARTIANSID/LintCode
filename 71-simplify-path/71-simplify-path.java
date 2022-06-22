class Solution {
    
    public boolean isCommand(String s){
        int cnt=0,ch=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.')cnt++;
            else ch++;
        }
        if(ch!=0)return false;
        else if(cnt==2)return true;
        else return false;
    }
    
    public String simplifyPath(String path) {        
        int n=path.length();
        String[] foldersOrCommands=path.split("/");
        Stack<String>  st=new Stack<>();
        for(int i=1;i<foldersOrCommands.length;i++){
            String fileOrCommand=foldersOrCommands[i];
            if(fileOrCommand.length()==0 || (fileOrCommand.length()==1 && fileOrCommand.charAt(0)=='.'))continue;
            if(isCommand(fileOrCommand)){
                if(st.size()!=0){
                     st.pop();
                }
               
            }else{
                st.push("/"+foldersOrCommands[i]);
            }
        }
        String ans="";
        if(st.size()==0)st.push("/");
        int i=0;
        while(i<st.size()){
            ans+=st.get(i++);
        }
        return ans;

    }
}