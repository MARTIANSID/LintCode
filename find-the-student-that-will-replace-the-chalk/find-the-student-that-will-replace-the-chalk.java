class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
            
        for(int i=0;i<chalk.length;i++){
            sum+=chalk[i];
        }
        
        long m=k;
        m=m%sum;
        
        for(int i=0;i<chalk.length;i++){
            if(chalk[i]>m)return i;
            
            m-=chalk[i];
        }
        
        return 0;
    }
}