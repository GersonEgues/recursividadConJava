
public class E87{
    public boolean curioso(int n){
        return n == sumafactorial(n);
    }
    private int sumafactorial(int n){
        int suma = 0;
        if(n<10){ 
            suma = factorial(n);
        }else{
            suma = factorial(n%10) + sumafactorial(n/10); 
        }
        return suma;
    }
    private int factorial(int n){
        return (n==0 || n==1 )?1:n*factorial(n-1);
    }
}
