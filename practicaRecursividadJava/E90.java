
public class E90{
    public boolean monticulo(int n){
        int ase = getAsendente(n/10,n%10);
        return asendente(ase/10,ase%10);
    }
    private boolean asendente(int n,int last){
        boolean ans = false;
        if(n<10){
            if(n<=last){
                ans = true;
            }
        }else{
            ans = (n%10 <= last) && (asendente(n/10,n%10));
        }
        return ans;
    }
    private int getAsendente(int n,int last){
        if(n<10){
            if(last<=n){
                n = n/10;
            }
        }else{
            if(last<=n%10){
                n = getAsendente(n/10,n%10);
            }
        }
        return n;
    }
}
