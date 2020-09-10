
public class E68{
    public int pentagono(int n){
        return n + (3*serie(n));
    }
    private int serie(int n){
        int ans = 0;
        if(n==1){
            ans = 0;
        }else{
            ans = serie(n-1) + n-1;
        }
        return ans;
    }
}
