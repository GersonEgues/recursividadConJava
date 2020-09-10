
public class E18{
    public int promedio(int n){
        return promedio2(invertir(n),-1);
    }
    private int promedio2(int n,int m){
        int prom = 0;
        if(n<10){
            prom = n*m;
        }else{
            prom = n%10 * m;
            prom += promedio2(n/10,m*-1);
        }
        return prom;
    }
    //------------------------------------------
    private int invertir(int n){
        int udc = (int)(Math.log10(n));
        return invertir(n,udc);
    }
    private int invertir(int n,int udc){
        int numero = 0;
        if(n<10){
            numero = n;
        }else{
            numero = n%10 * (int)(Math.pow(10,udc));
            numero += invertir(n/10,udc-1);
        }
        return numero;
    }
}
