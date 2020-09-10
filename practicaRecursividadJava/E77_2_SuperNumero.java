
public class E77_2_SuperNumero{
    public boolean superNumero(int n){
        boolean ans[] = {true};
        superNumero(n,2,ans);
        return ans[0];
    }
    private int superNumero(int n,int pow,boolean ans[]){
        int suma = 0;
        if(n<10){
            suma = (int)Math.pow(n,pow);
        }else{
            int nn_1 = superNumero(n/10,pow+1,ans);
            int nn = sumatoriaPow(n,pow);
            suma = nn;
            if(!(nn < nn_1) && ans[0]){
                ans[0] = false;
            } 
        }
        return suma;
    }
    private int sumatoriaPow(int n,int pow){
        int suma = 0;
        if(n<10){
            suma = (int)Math.pow(n,pow);
        }else{
            suma = ((int)Math.pow(n%10,pow)) + sumatoriaPow(n/10,pow); 
        }
        return suma;
    }
}
