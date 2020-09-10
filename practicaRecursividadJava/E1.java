public class E1
{
    public int potencia(int a,int b){
        return (b==1)? a : a * potencia(a,b-1);
    }
}
