
public class E21{
    public int sumaPares(int n){
        return sumaPares(6,n);
    }
    private int sumaPares(int num,int n){
        int suma = 0;
        if(n>0){
            if(num%2 == 0 && num%4 != 0){
                System.out.println(num);
                suma = num;
                suma += sumaPares(num+1,n-1);
            }else{
                suma += sumaPares(num+1,n);
            }
        }
        return suma;
    }
}
