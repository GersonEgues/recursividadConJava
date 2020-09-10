
public class E23{
    public boolean incremental(int n){
        boolean ans = true;
        if(n>10){
            ans = incremental(n/10) && (n/10)%10 <= n%10;
        }
        return ans;
    }
}