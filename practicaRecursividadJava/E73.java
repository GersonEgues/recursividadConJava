
/**
 * k = 13, sqrt(13)=3.60 = 4 , i = [2,3,4], si 13%i != 0 -> primo
 * 
 * 
 */
public class E73{
    public int primerTermino(int n){
        if(n==1){
            return 2;
        }else{
            int ini = (int)Math.pow(10,n-1);
            return pt(ini);
        }
    }
    private int pt(int ini){
        int fin = (int)Math.round(Math.sqrt(ini));
        if(primo(ini,2,fin)){
            return ini;
        }else{
            return pt(ini+1); 
        }
    }
    private boolean primo(int n,int ini,int fin){
        boolean esPrimo = true;
        if(ini<=fin && esPrimo){
            if(n%ini==0){
                esPrimo = false;
                //System.out.println(n + " -> " + ini);
            }else{
                esPrimo = primo(n,ini+1,fin);
            }
        }
        return esPrimo;
    }
}
