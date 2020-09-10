
public class E27{
    private int arr[];
    public E27(int a[]){
        arr = a;
        arr = ordenar(arr,0,1);
    }
    public int nesimo(int i){
        if(i<arr.length){
            return arr[i-1];
        }else{
            return -1;
        }
    }
    //------------------------------------------------
    private int[] ordenar(int a[],int i,int j){
        if(i<a.length){
            ordenar2(a,i,j);
            ordenar(a,i+1,j+1);
        }
        return a;
    }
    private void ordenar2(int a[],int i,int j){
        if(j<a.length){
            if(a[i]>a[j]){
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
            ordenar2(a,i,j+1);
        }
    }
}
