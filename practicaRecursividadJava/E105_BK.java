
public class E105_BK{
    private int mat[][] = {{ 1,-1, 2, 4, 6, 7, 8},
                           {-3, 1, 6, 7,-1,-1,-4},
                           { 6, 5, 3, 3, 2, 8,-5},
                           { 3, 6, 8,-4, 6, 7, 1}};
                           
    public int maximaSuma(int i,int j,int x,int y){
        int max[] = {-1};
        int suma[] = {0};
        ms(i,j,x,y,max,suma);
        return max[0];
    }
    private void ms(int i,int j,int x,int y,int max[],int suma[]){
        if(posicionValida(i,j,mat)){
            if(i==x && j==y){
                suma[0]+=mat[i][j];
                if(suma[0]>max[0]){
                    max[0] = suma[0];
                }
                suma[0]-=mat[i][j];
            }else{
                if(mat[i][j]>=0){
                    int n = mat[i][j];
                    mat[i][j] = -1;
                    
                    suma[0] += n;
                    ms(i-1,j-1,x,y,max,suma);//up-left
                    ms(i-1,j+1,x,y,max,suma);//up-left
                    ms(i+1,j-1,x,y,max,suma);//up-left
                    ms(i+1,j+1,x,y,max,suma);//up-left
                    
                    suma[0]-=n;
                    mat[i][j] = n;
                    
                }
            }
        }
    }
    private boolean posicionValida(int x,int y,int mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
}
