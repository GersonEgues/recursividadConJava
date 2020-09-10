
public class E65{
    public int cubico(int n){
        int n1 = n + (n-1)*(n-1);
        return cubico(n1,n1,n-1);
    }
    private int cubico(int n1,int suma,int cont){//c conttador
        if(cont>0){            
            suma = cubico(n1+2,suma+(n1+2),cont-1);
        }
        return suma;
    }
}
