
public class E82{
    public String cadena(int n){
        String ans = cadenaC(n);
        System.out.println(ans);
        return ans;
    }
    private String cadenaC(int n){
        String ans = "";
        if(n==1){
            ans = "aba";
        }else{
            ans = getAB(n-1)+cadenaC(n-1)+getBA(n-1);
        }
        return ans;
    }
    private String getAB(int n){
        String ans = "";
        if(n==1){
            ans = "ab";
        }else{
            ans = "ab"+getAB(n-1);
        }
        return ans;
    }
    private String getBA(int n){
        String ans = "";
        if(n==1){
            ans = "ba";
        }else{
            ans = "ba"+getBA(n-1);
        }
        return ans;
    }
}
