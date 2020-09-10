
public class E97{
    public String palabraDesequilibrada(String str){
        String sec[] = str.split(" ");
        int sec2[] = new int[sec.length];
        getSecuencia(sec,sec2,0);
        int index = resolver(sec2,0,sec2.length-1);        
        return (index==-1)?"no tiene palabra de desequilibrio.":sec[index];
    }
    private int resolver(int sec[],int i,int j){
        int index = -1;
        if(i+1==j){
            if(sec[i]!=sec[j]){
                index = (sec[i]>sec[j])?i:j;
            }
        }else{
            int m = (i+j)/2;
            if(j%2!=0){
                m+=1;
            }
            int suma1 = getSuma(sec,i,m);//[_[
            int suma2 = getSuma(sec,m,j+1);//[_[  
            if(suma1!=suma2){
                if(suma1>suma2){
                    index = resolver(sec,i,m-1);
                }else{
                    index = resolver(sec,m,j);
                }
            }
        }   
        return index;
    }
    private int getSuma(int sec[],int i,int j){
        int ans = 0;
        if(i<j){
            ans = sec[i] + getSuma(sec,i+1,j);
        }
        return ans;
    }
    private void getSecuencia(String sec[],int ans[],int i){
        if(i<sec.length){
            ans[i] = sec[i].length();
            getSecuencia(sec,ans,i+1);
        }
    }
}