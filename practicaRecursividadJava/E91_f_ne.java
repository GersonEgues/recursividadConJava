
public class E91_f_ne{
    private char mapa1[][] = {{'V','V','V','V','V','F','F','F','F','F','C','C','C','C','C'},
                              {'V','V','V','V','V','C','C','C','C','C','C','C','C','C','C'},
                              {'C','C','C','V','V','V','V','V','V','V','V','L','F','F','F'},
                              {'C','C','V','V','V','V','V','V','V','V','V','F','F','F','F'},
                              {'C','C','C','C','C','C','C','V','V','V','V','V','F','F','F'},
                              {'C','C','F','F','F','F','C','C','C','V','V','V','F','C','C'},
                              {'C','C','C','F','F','C','C','C','C','V','V','V','A','C','C'},
                              {'C','C','C','C','C','C','C','C','C','F','F','F','F','F','F'}};
                              
    private char mapa2[][] = {{'V','F','F'}, //???
                              {'V','A','C'},
                              {'V','F','F'}};
    
    public int maximaCantidadDeFlores(){
        int max[] = new int[1];
        int cf[] = new int[1];
        flores(0,0,mapa2,max,cf);
        return max[0];
    }
    private void flores(int i,int j,char mat[][],int max[],int cf[]){//cf = contador flores
        if(posicionValida(i,j,mat)){
            char c = mat[i][j];
            if(mat[i][j]!='C' && mat[i][j]!='X'){
                if(c=='A'){
                    if(cf[0]>max[0]){
                        max[0] = cf[0];
                    }
                }else{
                    if(c=='F'){
                        cf[0] += 1;
                    }
                    mat[i][j] = 'X';
                    flores(i-1,j,mat,max,cf);//up
                    flores(i,j+1,mat,max,cf);//rigth                        
                    flores(i+1,j,mat,max,cf);//down  
                    flores(i,j-1,mat,max,cf);//left
                    
                    mat[i][j] = 'V';
                }
            }
        }        
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private boolean posicionValida(int x,int y,char mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
}
