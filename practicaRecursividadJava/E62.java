import java.util.ArrayList;

public class E62{
    public int eliminarNumerosRepetidos(int n){
        int flag[] = new int[10];
        int pow = (int)Math.log10(n);
        ArrayList<Integer> nn = eliminar(n,pow,flag,new ArrayList<Integer>());
        //System.out.println(nn);
        return numero(nn,0,nn.size()-1);
    }
    private ArrayList<Integer> eliminar(int n,int pow,int flag[],ArrayList<Integer> ans){
        if(n<10){
            if(flag[n]==0){
                ans.add(n);
            }
        }else{
            int p = (int)Math.pow(10,pow);
            int a = n / p;
            if(flag[a] == 0){
                ans.add(a);
                flag[a] = 1;
                eliminar(n%p,pow-1,flag,ans); 
            }else{
                eliminar(n%p,pow-1,flag,ans); 
            }
        }
        return ans;
    } 
    private int numero(ArrayList<Integer> num,int i,int pow){
        int n = 0;
        if(pow>=0){
            n = (num.get(i) * (int)Math.pow(10,pow)) + numero(num,i+1,pow-1);
        }
        return n;
    }
}
