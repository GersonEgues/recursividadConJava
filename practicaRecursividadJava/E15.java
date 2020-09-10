
public class E15{
    public boolean divisor11(int n){
        int tam = (int)(Math.log10(n));
        int sp = sumaPares((tam%2==0)?n:n/10);
        int si = sumaInpares((tam%2==0)?n/10:n);
        System.out.println(sp + " - " + si + " - " + " - " + (sp-si));
        return (sp-si)%11==0;
    }
    private int sumaPares(int n){
        int suma = 0;
        if(n<10){
            if(n!=0){
                suma = n;
            }
        }else{
            suma = n%10;
            suma += sumaPares(n/100);
        }
        return suma;
    }
    private int sumaInpares(int n){
        int suma = 0;
        if(n<10){
            if(n!=0){
                suma = n;
            }
        }else{
            suma = n%10;
            suma += sumaPares(n/100);
        }
        return suma;
    }
}
