public class SerieFibonaci{
    public int serieFibonaci(int i){
        int fibo = 0;
        if(i<2){
            fibo = (i==0)?0:1;
        }else{
            fibo = serieFibonaci(i-1) + serieFibonaci(i-2);
        }
        return fibo;
    }
}
