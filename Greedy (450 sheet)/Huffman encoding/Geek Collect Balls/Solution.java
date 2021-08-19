class Solution{
    static int maxBalls(int N, int M, int a[], int b[])
    {
    
        
    int i=0,j=0,sum1=0,sum2=0,ans=0;
    
    while(i<N&&j<M){
        if(a[i]<b[j]){
            sum1+=a[i++];
        }else if(b[j]<a[i]){
            sum2+=b[j++];
        }else{
            int x=i;
            int y=j;
            while(i+1<N&&a[i]==a[i+1])sum1+=a[i++];
            while(j+1<M&&b[j]==b[j+1])sum2+=b[j++];
            if(sum1>sum2){
                ans+=sum1+a[i];
                j=y+1;
                i++;
            }else {
                ans+=sum2+a[i];
                i=x+1;
                j++;
            }
            sum1=0;
            sum2=0;
            
        }
        
    }
    
    while(i<N){
        sum1+=a[i++];
    }
    while(j<M){
            sum2+=b[j++];     
    }
    ans+=Math.max(sum1,sum2);
    
    return ans;
        
        
    }  
}   