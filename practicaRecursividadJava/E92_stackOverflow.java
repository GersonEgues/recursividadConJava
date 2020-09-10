import java.util.ArrayList;

public class E92_stackOverflow{
    public boolean sociables(int sec[]){
        return sociables(sec,0);
    }    
    private boolean sociables(int sec[],int i){
        boolean ans = false;
        if(i==sec.length-1){
            if(sumaDivisores(sec[i],1,(sec[i]/2)+1) == sec[0]){
                ans = true;
            }
        }else{
            if(sumaDivisores(sec[i],1,(sec[i]/2)+1) == sec[i+1]){
                ans = true && sociables(sec,i+1);
            }else{
                ans = false;
            }
        }    
        return ans;
    }
    private int sumaDivisores(int n,int i,int j){
        int suma = 0;
        if(i==j){
            if(n%i==0){
                suma = i;
            }
        }else{
            if(n%i==0){
                suma = i + sumaDivisores(n,i+1,j);
            }else{
                suma = sumaDivisores(n,i+1,j);
            }
        }
        return suma;
    }
}
