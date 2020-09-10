
public class E46_8Reinas_{
    private int mapa1[][] = {{0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0}};
    
    public void setReinas(){
        print(mapa1);
        setReinas(0,0,mapa1,0);
        print(mapa1);
    }
    private void setReinas(int i,int j,int mat[][],int cont){
        if(posicionValida(i,j,mat) && cont!=8){
            if(!posAtacada(i,j,mat)){
                mat[i][j] = 1;
                cont+=1;
                atacar(i,j,mat);
                setReinas(0,j+1,mat,cont);
                
                mat[i][j]=0;
                cont-=1;
                setReinas(i+1,j,mat,cont);
            }else{
                setReinas(i+1,j,mat,cont);
            }
        }
    }
    private boolean posAtacada(int i,int j,int mat[][]){
        return true;//!dPrin(i,j,getPos(i,j,mat)) && !dSeg(i,j,getPos2(i,j)) && !fila(i,j,0,j) && !columna(i,j,i,0);
    }
    private boolean dPrin(int i,int j,int p[]){
        boolean ans = false;
        if(p[0]>=0&&p[1]<8){
        
        }
        return ans;
    }
    private void atacar(int i,int j,int mat[][]){
    }
    //diagonal principal
    private int[] getPos(int i,int j,int mat[][]){
        int ans[] = {i-1,j+1};
        if(i<mat.length && j>=0){
            ans = getPos(i+1,j-1,mat); 
        }
        return ans;
    }
    //diagonal segundaria
    private int[] getPos2(int i,int j){
        int ans[] = {i+1,j+1};
        if(i>=0 && j>=0){
            ans = getPos2(i-1,j-1); 
        }
        return ans;
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private boolean posicionValida(int x,int y,int mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
    private void print(int mat[][]){
        for(int i=0;i<mat.length;i++ ){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
