
public class E53{
    public double Sn(int n){
        return Sn(1,n,n);
    }
    private double Sn(int i,int j,int n){
        double ans = 0;
        if(i==n){
            ans = i + An(j);
        }else{
            ans = i + An(j)*Sn(i+1,j-1,n);
        }
        return ans;
    }
    private double An(int n){
        return funcionSeno(1,n,0);
    }
    private double funcionSeno(int i,int n,int signo){//0 negativo, 1 positivo
        double ans = 0;
        if(i==n){
            ans = Math.sin(n);
        }else{
            if(signo==0){
                ans = Math.sin(i-funcionSeno(i+1,n,1)); 
            }else{ 
                ans = Math.sin(i+funcionSeno(i+1,n,0));
            }            
        }
        return ans;
    }
}