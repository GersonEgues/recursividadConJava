
public class E106{
    public int arbol(int n){
        int ans = 0;
        if(n==1){
            ans = 6;
        }else{
            ans = arbol(n-1) + ((2*n)+1) + 2;
        }
        return ans;
    }
}
