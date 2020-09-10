
public class E66{
    public int hexagonoo(int n){
        return n * hexagono(n);
    }
    private int hexagono(int n){
        int ans = 0;
        if(n==1){
            ans = 6;
        }else{
            ans = hexagono(n-1)+9;
        }
        return ans;
    }
}
