import java.util.ArrayList;

public class E102_BK{
    private int mapa1[][] = {{1,1,0,0},
                             {1,0,0,1},
                             {0,1,1,0},
                             {0,0,0,0}};
                             
    public boolean pollito(int k){
        ArrayList<ArrayList<Integer>> posiciones = new ArrayList<>();        
        boolean ans = buscar(0,mapa1,k+1,posiciones);
        System.out.println(posiciones);
        return ans;
    }
    private boolean buscar(int i,int mat[][],int k,ArrayList<ArrayList<Integer>> posiciones){
        boolean encontro = false;
        if(i<mat.length && !encontro){
           encontro = buscar(i,0,mat,k,posiciones);
           if(!encontro){
               posiciones.clear();
               encontro = buscar(i+1,mat,k,posiciones);
           }
        }
        return encontro;
    }
    private boolean buscar(int i,int j,int mat[][],int k,ArrayList<ArrayList<Integer>> posiciones){
        boolean encontro = false;
        if(j<mat[i].length && !encontro){
            if(mat[i][j]==0){
                int numAsientos = numeroAsientos(i,j,mat,k,posiciones);
                encontro = (numAsientos==k)?true:false;
            }
            
            if(!encontro){
                posiciones.clear();
                encontro = buscar(i,j+1,mat,k,posiciones);
            }
        }
        return encontro;
    }
    private int numeroAsientos(int i,int j,int mat[][],int k,ArrayList<ArrayList<Integer>> posiciones){
        int numAsientos = 0;
        if(posicionValida(i,j,mat)){
            if(mat[i][j]!=1 && mat[i][j]!=2 && posiciones.size()!=k){
                mat[i][j] = 2;
                
                ArrayList<Integer> pos = new ArrayList<>();
                pos.add(i);
                pos.add(j);                
                posiciones.add(pos);
                
                numAsientos = 1;
                numAsientos += numeroAsientos(i-1,j,mat,k,posiciones);
                numAsientos += numeroAsientos(i,j+1,mat,k,posiciones);
                numAsientos += numeroAsientos(i+1,j,mat,k,posiciones); 
                numAsientos += numeroAsientos(i,j-1,mat,k,posiciones);                
            }
        }
        return numAsientos;
    }
    private boolean posicionValida(int x,int y,int mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
}