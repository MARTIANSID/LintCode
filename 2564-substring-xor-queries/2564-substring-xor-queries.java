class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n=s.length();
        int m=queries.length;
        
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                int[] temp=new int[2];
                temp[0]=i;
                temp[1]=i;
                map.put(0,temp);
            }
            int no=0,power=0;
            for(int j=i;j>i-32;j--){
                if(j<=-1)break;
                if(s.charAt(j)=='1'){
                  no+=Math.pow(2,power);
                int[] temp=new int[2];
                temp[0]=j;
                temp[1]=i;
                map.put(no,temp);
                }
                power++;
            }
        }
     
        int[][] ans=new int[queries.length][2];
        int index=0;
        for(int[] q:queries){
            int l=q[0],r=q[1];
            int no=0;
            for(int i=31;i>=0;i--){
                int x=(1<<i);
                int bitL=(l&x)==0?0:1;
                int bitR=(r&x)==0?0:1;
                if(bitL!=bitR){
                    no=no+(int)Math.pow(2,i);
                }
            }

            if(map.containsKey(no)){
                ans[index++]=map.get(no);
            }else{
                ans[index++]=new int[]{-1,-1};
            }
        }
        return ans;
    }
}

