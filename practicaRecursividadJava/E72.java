
public class E72{
    public int maximo(int sec[]){
        int max[] = new int[1];
        maximo(0,sec,max,0);
        return max[0];
    }
    private void maximo(int i,int sec[],int max[],int cont){
        if(i<sec.length){
            if(i+1<sec.length){
                if(sec[i]<=sec[i+1]){
                    cont+=sec[i];
                }else{
                    cont+=sec[i];
                    if(cont>max[0]){
                        max[0]=cont;
                    }
                    cont=0;
                }
                maximo(i+1,sec,max,cont);
            }else{
                cont+=sec[i];
                if(cont>max[0]){
                    max[0]=cont;
                }
            }
        }
    }
}
