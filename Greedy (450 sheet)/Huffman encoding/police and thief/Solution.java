class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
	    List<Integer>  police=new ArrayList<>();
	    List<Integer> thief=new ArrayList<>();
	    for(int i=0;i<n;i++){
	        if(arr[i]=='T'){
	            thief.add(i);
	        }else{
	            police.add(i);
	        }
	    }
	    
	    int i=0,j=0,ans=0;
	    
	    while(i<police.size()&&j<thief.size()){
	        int t=thief.get(j);
	        if(t>=police.get(i)-k&&police.get(i)+k>=t){
	            ans++;
	            i++;
	            j++;
	        }else if(police.get(i)+k<t){
	            i++;
	        }else{
	            j++;
	        }
	    }
	    
	    
	    return ans;
	    
               
	} 
} 



// without space solution



class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
	 
	    int p=0,t=0,ans=0;
	    while(p<n&&t<n){
	        while(p<n&&arr[p]!='P')p++;
	        while(t<n&&arr[t]!='T')t++;
	        if(p==n||t==n)return ans;
	        if(t>=p-k&&t<=p+k){
	            ans++;
	            p++;
	            t++;
	        }else if(t<p-k){
	            t++;
	        }else{
	            p++;
	        }
	    }
	    
	    return ans;
          
	} 
} 