
public class E29{
    public boolean par(int n){
        boolean res = false;
        if(n>1){
            return (impar(n-1))?true:false;
        }
        return res;
    }
    public boolean impar(int n){
        boolean res = true;
        if(n>1){
            res = (par(n-1))?true:false;
        }
        return res;
    }
}
