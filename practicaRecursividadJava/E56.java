
public class E56{
    public boolean divisible7(int n){// n es divisible entre 7
        boolean ans = false;
        if(n<10){
            if(n==0||n==7){
                ans = true;
            }
        }else{
            ans = divisible7((n/10)-(n%10)*2); 
        }
        return ans;
    }
}
