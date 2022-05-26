class Solution {

    public int matrixScore(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        //flip row logic
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                //flip this row
                for (int j = 0; j < m; j++) {
                    arr[i][j] = 1 - arr[i][j];
                }
            }
        }

        //flip column logic

        for (int i = 0; i < m; i++) {
            int oneCount = 0, zeroCount = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 1) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            if (zeroCount > oneCount) {
                //flip this column
                for (int j = 0; j < n; j++) {
                    arr[j][i]=1-arr[j][i];
                }
            }
        }
        
        int sum=0;
        
        for(int i=0;i<n;i++){
            int no=0,index=0;
            for(int j=m-1;j>=0;j--){
                if(arr[i][j]==1){
                    no+=1<<index;
                }
                index++;
            }
            sum+=no;
        }
        return sum;
    }
}
