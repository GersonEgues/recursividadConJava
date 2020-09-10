
public class E24{
    public boolean decremental(int n){
        boolean ans = true;
        if(n>10){
            ans = decremental(n/10) && (n/10)%10 >= n%10;
        }
        return ans;
    }
}
