import java.util.ArrayList;

public class E96{
    public ArrayList<Integer> alicuota(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        if(n==0){
            ans.add(n);
        }else if(n==1){
            ans.add(n);
            ans.addAll(alicuota(n-1));
        }else{
            ArrayList<Integer> sec = new ArrayList<>();
            int nn = 0;
            if(n%2==0){
                nn = secuencia(sec,n,n,n);
            }else{
                sec.add(n);
                sec.add(1);
                nn = 1;
            }            
            ans.addAll(sec);
            ans.addAll(alicuota(nn));
        }
        return ans;
    }
    private int secuencia(ArrayList<Integer> sec,int ni,int n,int suma){
        int ans = 0;
        if(n==1){
            sec.add(n);
            ans = suma-ni;            
        }else{
            sec.add(n);            
            ans = secuencia(sec,ni,n/2,suma+n/2);
        }
        return ans;
    }
}
