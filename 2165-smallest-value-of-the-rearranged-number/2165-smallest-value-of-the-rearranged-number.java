class Solution {
    public long smallestNumber(long num) {
        String str="";
        
        boolean isNegetive=num<0;
        
        if(isNegetive)num=(-1)*num;
        
        
        while(num>0){
            str+=(num%10)+"";
            num/=10;
        }
        
        if(str.equals(""))str="0";
       
        char[] chars = str.toCharArray();
        
      
        Arrays.sort(chars);
        
        if(isNegetive)
        reverse(chars);
    
        
        
        int index=-1;
        for(int i=0;i<chars.length;i++){
            if(chars[i]!='0'){
                index=i;
                break;
            }
        }
        if(index!=-1 && chars[0] == '0'){
            char temp=chars[0];
            chars[0]=chars[index];
            chars[index]=temp;
        }
        return  isNegetive ?  (-1)*Long.parseLong(new String(chars)) : Long.parseLong(new String(chars));
    }
    public static void reverse(char[] array) {
       
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            char temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
     
    }
}