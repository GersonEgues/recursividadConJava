public class E14 {
    public boolean todosPares(int n){
        boolean ans = true;
        if(n<10){
            if(n%2!=0){
                ans = false;
            }
        }else{
            if(n%2!=0){
                ans = false;
            }else{
                ans = todosPares(n/10);
            }
        }
        return ans;
    }
}
