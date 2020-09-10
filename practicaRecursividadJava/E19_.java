
public class E19_{ 
    public int ackerman(int m,int n){
        int ans = 0;
        if(m==0){
            ans = n+1;
        }else if(n==0){
            ans = ackerman(m-1,1);
        }else if(m>0 && n>0){
            ans = ackerman(m-1,ackerman(m,n-1));
        }
        return ans;
    }
}
