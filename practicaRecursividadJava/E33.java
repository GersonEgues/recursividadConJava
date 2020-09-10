import java.util.HashSet;

public class E33{
    private HashSet<Integer> set;
    public E33(){
        set = new HashSet<>();
    }
    public int eliminar(int n){
        set.clear();
        return invertir(eliminar(invertir(n),0));
    }
    private int eliminar(int n,int udc){
        int suma = 0;
        if(n<10){
            if(set.add(n)){
                suma = n * (int)(Math.pow(10,udc));
            }
        }else{
            if(set.add(n%10)){
                suma = n%10 * (int)(Math.pow(10,udc));
                suma += eliminar(n/10,udc+1);
            }else{
                suma += eliminar(n/10,udc);
            }
        }
        return suma;
    }
    private int invertir(int n){
        int t = (int)(Math.log10(n));
        return invertir(n,t);
    }
    private int invertir(int n,int udc){
        int suma = 0;
        if(n<10){
            suma = n*(int)(Math.pow(10,udc));
        }else{
            suma = n%10 * (int)(Math.pow(10,udc));
            suma += invertir(n/10,udc-1);
        }
        return suma;
    }
}
