
public class E70_CarbonoMasLargo_BK{
    private int mapa1[][] = {{0,1,0,0,0,0,0,0,0,0,0,0},
                             {1,1,0,1,0,0,0,0,0,0,0,0},
                             {0,1,0,1,0,0,0,0,0,1,0,0},
                             {0,1,0,1,0,0,0,0,0,1,0,0},
                             {0,1,1,1,1,1,1,1,1,1,0,0},
                             {0,1,0,0,0,0,0,0,0,0,0,0},
                             {0,1,0,0,0,0,0,0,0,0,0,0}};
                             
    private int mapa2[][] = {{0,1,0},
                             {0,1,1},
                             {1,1,0}};
                             
    public int carbonoMasLargo(){
        int max[] = new int[1];
        carbono(0,1,mapa1,max,0);
        return max[0];
    }
    private void carbono(int i,int j,int mat[][],int max[],int cont){
        if(posicionValida(i,j,mat)){
            if(mat[i][j]==1){
                mat[i][j] = 0;
                cont += 1;
                carbono(i-1,j,mat,max,cont);//up
                carbono(i,j+1,mat,max,cont);//rigth
                carbono(i+1,j,mat,max,cont);//down                            
                carbono(i,j-1,mat,max,cont);//left
                if(cont>max[0]){
                    max[0]=cont;
                }
                cont-=1;
                mat[i][j] = 1;
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private boolean posicionValida(int x,int y,int mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
}
