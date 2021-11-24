class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] comp1=num1.split("\\+");
        comp1[1]=comp1[1].substring(0,comp1[1].length()-1);
        
        String[] comp2=num2.split("\\+");
        comp2[1]=comp2[1].substring(0,comp2[1].length()-1);
        
        int real=Integer.parseInt(comp1[0])*Integer.parseInt(comp2[0])-Integer.parseInt(comp1[1])*Integer.parseInt(comp2[1]);
        int imaginary=Integer.parseInt(comp1[0])*Integer.parseInt(comp2[1])+Integer.parseInt(comp2[0])*Integer.parseInt(comp1[1]);
        
      return ""+real +"+"+imaginary+"i";
        
     
        
    }
}