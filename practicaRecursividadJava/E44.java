import java.util.ArrayList;

public class E44{
    public int primosEnFibonaci(int numFibo){
        ArrayList<Integer> lista = generarSerie(numFibo);
        System.out.println(lista);
        int num =  primos(lista,0);
        return num;
    }
    private int primos(ArrayList<Integer> lista,int i){
        int suma = 0;
        if(i<lista.size()){
            if(primo(lista.get(i))){
                //System.out.println(lista.get(i));
                suma=1;                
            }
            suma += primos(lista,i+1);
        }
        return suma;
    }
    private boolean primo(int k){
        boolean ans = false;
        if(k>=2){         
            ans = true;
            int i=2;
            while(i<k && ans){
                if(k%i==0){
                    ans = false;
                }
                i+=1;
            }
        }
        return ans;
    }
    private ArrayList<Integer> generarSerie(int i){
        ArrayList<Integer> lista = new ArrayList<>();
        if(i>=0){
            lista.add(serieFibonaci(i));
            lista.addAll(0,generarSerie(i-1));
        }
        return lista;
    } 
    private int serieFibonaci(int i){
        int fibo = 0;
        if(i<2){
            fibo = (i==0)?0:1;
        }else{
            fibo = serieFibonaci(i-1) + serieFibonaci(i-2);
        }
        return fibo;
    }
}
