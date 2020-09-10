
public class E30{
   public int digitos(int n){
       return digitos2(invertir(n));
   }
   private int digitos2(int n){
       int suma = 0;
       if(n<10){
           if(n!=0)
               suma = (n%2==0)?1:0;
       }else{
           if((n%10)%2 == 0){
               suma = 1 + digitos2(n/100);
           }else{
               suma = digitos2(n/100);
           }
       }
       return suma;
   }
   //-------------------------------
   private int invertir(int n){
       return invertir(n,(int)(Math.log10(n)));
   }
   private int invertir(int n,int udc){
       int res = 0;
       if(n<10){
           res = n * (int)(Math.pow(10,udc));
       }else{
           res = n%10 * (int)(Math.pow(10,udc)) + invertir(n/10,udc-1);
       }
       return res;
   }
}
