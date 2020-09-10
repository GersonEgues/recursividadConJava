public class E2{
    public boolean primo(int n){
        return primo(n,n/2,2);
    }
    private boolean primo(int n,int lim,int i){
        boolean ans = true;
        if(i<=lim){
            if(n%i == 0){
               ans = false; 
            }else{
               ans = primo(n,lim, i+1);
            }
        }
        return ans;
    }
}