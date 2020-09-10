
public class E69{
    public String posible(int n){
        int t = (int)(Math.log10(n));
        if(ocho(n)&&t>0){
            String num = getNumero(t,9); 
            return  num + " X " + 9 + " + " + ((Integer.parseInt(""+num.charAt(num.length()-1))) - 2); 
        }else{
            return "No es posible";
        }
    }
    private String getNumero(int c,int i){
        String ans = "";
        if(c>0){
            ans = i+getNumero(c-1,i-1);
        }
        return ans;
    }
    private boolean ocho(int n){
        boolean ans = false;
        if(n<10){
            ans = (n==8)?true:false;
        }else{
            ans = n%10==8 && ocho(n/10);
        }
        return ans;
    }
}