class Solution
{
    public String LexicographicallyMinimum(String str)
    {
        int[] freq=new int[26];
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        
        
        int[] visited=new int[26];
        int n=str.length();
        for(int i=0;i<n;i++){
            if(visited[str.charAt(i)-'a']==1)continue;
            for(int j=0;j<26;j++){
                if(freq[j]>0&&(char)('a'+j)<str.charAt(i)&&visited[j]!=1){
                    String ans=replace(str.charAt(i),(char)('a'+j),str);
                    return ans;
                    
                }else if((char)('a'+j)>=str.charAt(i)){
                    break;
                }
                
                
            }
            visited[str.charAt(i)-'a']=1;
        }
        
        return str;
        
        
    }
    public String replace(char ch1,char ch2,String str){
        char[] c = str.toCharArray(); 
        for(int i=0;i<c.length;i++){
            if(c[i]==ch1){
                c[i]=ch2;
                
            }else if(c[i]==ch2){
                c[i]=ch1;
            }
        }
        String ans=new String(c);
        return ans;
    }
}