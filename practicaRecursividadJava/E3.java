
public class E3{
    public int digitos(int n){
        int ans = 1;
        if(n>10){
            ans += digitos(n/10);
        }
        return ans;
    }
}
