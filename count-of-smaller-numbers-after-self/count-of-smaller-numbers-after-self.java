class Solution {
    
    class pair{
        int index;
        int val;
        int freq=0;
        pair(int index,int val){
            this.index=index;
            this.val=val;
            
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        
        
    pair[] p=    mergeSort(nums,0,nums.length-1);
     List<Integer> ans=new ArrayList<>();
        int[] result=new int[nums.length];
        for(int i=0;i<p.length;i++){
              result[p[i].index]=p[i].freq;
            
            // System.out.println(p[i].freq);
            //             System.out.println(p[i].val);

        }
        
        for(int i=0;i<result.length;i++){
            ans.add(result[i]);
        }
        
        return ans;
        
        
    }
    
    public pair[] mergeSort(int[] nums,int si,int  ei){
        
        if(si==ei){
            pair[] p=new pair[1];
            p[0]=new pair(si,nums[si]);
            return p;
        }
        
        int mid=(si+ei)/2;
        
        pair[] p2=   mergeSort(nums,mid+1,ei);
        pair[] p1=mergeSort(nums,si,mid);
        
        // [2,5]   [1,6]
        
        
        int i=0,j=0,val=0;
        
        // while(i<p1.length&&j<p2.length){
        //     if(p1[i].val>p2[j].val){
        //         for(int u=i;u<p1.length;u++){
        //             p1[u].freq++;
        //         }
        //         j++;
        //     }else{
        //         i++;
        //     }
        // }
        
        
        // 2,5   1,6
        //     1
        int ind=0;
        int globalVal=0;
        int[] count=new int[p1.length];
          while(i<p1.length&&j<p2.length){
            if(p1[i].val>p2[j].val){
                  globalVal++;
                 
                    
                j++;
            }else{
                count[i]+=globalVal;
                i++;
                
            }
              
        }
    
        for(int k=0;k<count.length;k++){
            if(count[k]!=0){
                p1[k].freq+=count[k];
            }else if(k>=i){
                p1[k].freq+=globalVal;
            }
        }
        
        
        
        
        
        pair[] p3=new pair[p1.length+p2.length];
        mergeArrays(p1,p2,p1.length,p2.length,p3);
        
        return p3;
        
        
    }
    
    
    void mergeArrays(pair arr1[], pair arr2[], int n1,
                             int n2, pair arr3[])
{
    int i = 0, j = 0, k = 0;
 
    while (i<n1 && j <n2)
    {
       
        if (arr1[i].val < arr2[j].val)
            arr3[k++] = arr1[i++];
        else
            arr3[k++] = arr2[j++];
    }
 
  
    while (i < n1)
        arr3[k++] = arr1[i++];
 
  
    while (j < n2)
        arr3[k++] = arr2[j++];
}
 
}


// [5,2,6,1]

// 2,5    1,6