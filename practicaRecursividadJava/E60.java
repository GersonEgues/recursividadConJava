
public class E60{
    public boolean siames(int n){
        int tam = (int)Math.log10(n);
        if(tam%2!=0){
            int a[] = getArreglo(n,new int[tam+1],tam);
            return siames(a,0,(tam+1)/2);
        }else{
            return false;
        }        
    }
    private int[] getArreglo(int n,int a[],int i){
        if(i>=0){
            a[i] = n%10;
            getArreglo(n/10,a,i-1);
        }
        return a;
    }
    private boolean siames(int a[],int i,int j){
        boolean ans = true;
        if(j<a.length){
            ans = (a[i] == a[j]) && siames(a,i+1,j+1); 
        }
        return ans;
    }
}
