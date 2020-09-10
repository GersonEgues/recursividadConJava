
public class E63{
    public int vueltas(int n){
        int nn = (n%10)*10 + (n/10+n%10)%10;
        return vueltas(n,nn,1);
    }
    private int vueltas(int n,int nn,int cont){
        if(n!=nn){
           int naux = (nn%10)*10 + (nn/10+nn%10)%10;
           cont = vueltas(n,naux,cont+1);
        }
        return cont;    
    }
}
