
public class E100_BK{
    private char mapa1[][] = {{'V','N','V'},
                              {'V','N','N'},
                              {'V','V','V'},
                              {'N','V','N'}};
    
    public int verduras(){
        return verduras(0,0,mapa1);
    }
    private int verduras(int i,int j,char mat[][]){
        int cont = 0;
        if(posicionValida(i,j,mat)){
            char c = mat[i][j];
            if(c!='X' && c!='N'){
                mat[i][j] = 'X';
                if(c=='V'){
                    cont = 1;
                }
                cont += verduras(i-2,j+1,mat);
                cont += verduras(i-1,j+2,mat);
                cont += verduras(i+1,j+2,mat);
                cont += verduras(i+2,j+1,mat);
                cont += verduras(i-2,j-1,mat);
                cont += verduras(i-1,j-2,mat);
                cont += verduras(i+1,j-2,mat);
                cont += verduras(i+2,j-1,mat);
            }
        }
        return cont;
    }
    private boolean posicionValida(int x,int y,char mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
}
