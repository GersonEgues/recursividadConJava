public class Secuencia{
    private int sec;
    public Secuencia(int s){
        sec = s;
    }
    // [6]
    public int sumar(Secuencia secuencia){
        int n1 = sec;
        int n2 = secuencia.getSecuencia();
        if(n1>n2){
            return sumar(n1,n2,0,0);
        }else{
            return sumar(n2,n1,0,0);
        }
    }
    //udc = unidad,decena,centena 
    private int sumar(int n1,int n2,int acarreo,int udc){
        int suma = 0;
        if(n2<10){
            int sumaUnidad = n2 + n1%10 + acarreo;
            suma = sumaUnidad * (int)(Math.pow(10,udc));
            suma += n1/10 * (int)(Math.pow(10,udc+1));                        
        }else{
            int sumaUnidad = n1%10 + n2%10 + acarreo;
            if(sumaUnidad>10){
                suma = sumaUnidad%10 * (int)(Math.pow(10,udc));
                suma += sumar(n1/10,n2/10,sumaUnidad/10,udc+1);
            }else{
                suma = sumaUnidad * (int)(Math.pow(10,udc));
                suma += sumar(n1/10,n2/10,0,udc+1);
            }
        }
        return suma;
    }
    //[7]
    public int getMinimo(){
        int n = sec;
        return minimo(n);
    }
    private int minimo(int n){
        int min = 0;
        if(n<10){
            min = n;
        }else{
            int m = minimo(n/10);
            min = (n%10 < m) ? n%10: m;
        }
        return min;
    }
    //[8]
    public int ordenar(){
        int n = sec;
        int tam = ((int)(Math.log10(n))) +1;
        int a[] = getArray(n,new int[tam],0);
        int b[] = ordenar(a,0,1);
        return toInt(b,0,tam-1);
    }
    private int[] getArray(int n,int res[],int i){
        if(n<10){
            res[i] = n;
        }else{
            res[i] = n%10;
            getArray(n/10,res,i+1);
        }
        return res;
    }
    private int[] ordenar(int a[],int i,int j){
        if(i<a.length){
            ordenar2(a,i,j);
            ordenar(a,i+1,j+1);
        }
        return a;
    }
    private int[] ordenar2(int a[],int i,int j){
        if(j<a.length){
            if(a[i]>a[j]){
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
            ordenar2(a,i,j+1);
        }
        return a;
    }
    private int toInt(int a[],int i,int udc){
        int suma = 0;
        if(i<a.length){
            suma = a[i] * (int)(Math.pow(10,udc));
            suma += toInt(a,i+1,udc-1);
        }
        return suma;
    }
    //[9]
    public int buscar(int x){
        int n = sec;
        int tam = (int)(Math.log10(n));
        return buscar(n,tam,x);
    }
    private int buscar(int n,int i,int x){
        if(n<10){
            if(n!=x){
                i = -1;
            }
        }else{
            if(n%10 != x){
                i = buscar(n/10,i-1,x);
            }
        }
        return i;
    }
    //[11] precido al [9]
    //[12]
    public int productoEscalar(int s){
        int n = sec;
        return productoEscalar(n,s);
    }
    private int productoEscalar(int n,int s){
        int suma = 0;
        if(n<10){
            suma = n * s;
        }else{
            suma = n%10*s%10;
            suma += productoEscalar(n/10,s/10);
        }
        return suma;
    }
    //[13]
    public int sumaPrimos(){
        int n = sec;
        return sumaPrimos(n);
    }
    private int sumaPrimos(int n){
        int suma = 0;
        if(n<10){
            if(primo(n)){
                System.out.println(n);
                suma = n;
            }
        }else{
            if(primo(n%10)){
                System.out.println(n%10);
                suma = n%10;
            }
            suma += sumaPrimos(n/10);
        }
        return suma;
    }
    //---------------------------------------------------------------
    //---------------------------------------------------------------
    public int getSecuencia(){
        return sec;
    }
    private boolean primo(int n){
        return primo(n,n/2,2);
    }
    private boolean primo(int n,int lim,int i){
        boolean ans = true;
        if(i<=lim){
            if(n%i == 0){
               ans = false; 
            }else{
               ans = primo(n,lim, i+1);
            }
        }
        return ans;
    }
}