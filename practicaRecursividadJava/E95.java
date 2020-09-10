
public class E95{
    public int copo(int n){
        int ans = 0;
        if(n==1){
            ans = 1;
        }else{
            ans = copo(n-1) + (int)Math.pow(2,getPow(n));
        }
        return ans;
    }
    private int getPow(int n){
        int ans = 0;
        if(n == 2){
            ans = 2;
        }else{
            ans = getPow(n-1) + 2;
        }
        return ans;
    }
}
