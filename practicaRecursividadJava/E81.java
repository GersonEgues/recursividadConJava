
public class E81{
    public int pares(int sec[],int i,int j){//i<=j, i>=0, j<sec.length, [i-j], 0->
        int cont = 0;
        if(i<=j){
            if(sec[i]%2==0){
                cont = 1 + pares(sec,i+1,j);
            }else{
                cont = pares(sec,i+1,j);
            }
        }
        return cont;
    }
}
