import java.util.ArrayList;

public class E77_CribaHeratostenes{
    public ArrayList<Integer> cribaHeratostenes(int n){
        int sec[] = new int[n+1];
        llenarSecuencia(sec,0);
        criba(2,sec);
        ArrayList<Integer> primos = getPrimos(2,sec);
        System.out.println(primos);
        return primos; 
    }
    private ArrayList<Integer> getPrimos(int i,int sec[]){
        ArrayList<Integer> ans = new ArrayList<>();
        if(i<sec.length){
            if(sec[i]!=-1){
                ans.add(sec[i]);
            }
            ans.addAll(getPrimos(i+1,sec));
        }
        return ans;
    }
    private void criba(int i,int sec[]){
        if(i<sec.length){
            if(sec[i]!=-1){
                marcarMultiplos(sec[i],i+1,sec);                
            }
            criba(i+1,sec);
        }
    }
    private void marcarMultiplos(int n,int i,int sec[]){
        if(i<sec.length){
            if(sec[i]!=-1 && sec[i]%n==0){
                sec[i]=-1;
            }
            marcarMultiplos(n,i+1,sec); 
        }
    }
    private void llenarSecuencia(int sec[],int i){
        if(i<sec.length){
            sec[i]=i;
            llenarSecuencia(sec,i+1);
        }
    }
}
