import java.util.ArrayList;

public class QuesoRaton_Bkt{
    private int mapa1[][] = {{0,0,0,1,1,0},
                             {0,1,0,0,0,0},
                             {0,1,1,1,1,0},
                             {0,1,0,0,1,1},
                             {0,0,0,1,0,2}};
                             
    private int mapa2[][] = {{0,1,1},
                             {0,0,0},
                             {0,0,2}};
                             
    public boolean hayCamino(int i,int j){        
        return hayCamino(0,0,mapa1);        
    }                        
    private boolean hayCamino(int i,int j,int mat[][]){
        boolean ans = false;
        if(posicionValida(i,j,mat)){
            if(mat[i][j]!=1){
                if(mat[i][j]==2){
                    ans = true;
                }else{//es cero = posicion libre
                    mat[i][j] = 1;
                    ans = hayCamino(i-1,j,mat);//up
                    if(!ans){
                        ans = hayCamino(i,j+1,mat);//rigth
                        if(!ans){
                            ans = hayCamino(i+1,j,mat);//down
                            if(!ans){
                               ans = hayCamino(i,j-1,mat);//left
                            }
                        }
                    }                    
                    mat[i][j] = 0;
                }
            }
        }
        return ans;
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    public int numeroCaminos(){
        return numeroCaminos(0,0,mapa2);    
    }
    private int numeroCaminos(int i,int j,int mat[][]){
        int ans = 0;
        if(posicionValida(i,j,mat)){
            if(mat[i][j]!=1){
                if(mat[i][j]==2){
                   ans = 1; 
                }else{//es cero
                    mat[i][j]=1;
                    ans += numeroCaminos(i-1,j,mat);//up
                    ans += numeroCaminos(i,j+1,mat);//rigth
                    ans += numeroCaminos(i+1,j,mat);//down
                    ans += numeroCaminos(i,j-1,mat);//left 
                    mat[i][j] = 0;
                }
            }
        }
        return ans;
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    public void todosLosCaminos(){
        ArrayList<ArrayList<ArrayList<Integer>>> caminos = new ArrayList<>();
        todosLosCaminos(0,0,mapa2,caminos,new ArrayList<ArrayList<Integer>>());
        System.out.println(caminos);
        System.out.println(caminos.size());
    }
    private void todosLosCaminos(int i,int j,int mat[][],ArrayList<ArrayList<ArrayList<Integer>>> caminos,ArrayList<ArrayList<Integer>> camino){
        //boolean ans = false;
        if(posicionValida(i,j,mat)){
            if(mat[i][j]!=1){
                if(mat[i][j]==2){
                   ArrayList<Integer> pair = new ArrayList<>();
                   pair.add(i);
                   pair.add(j);
                   camino.add(pair);
                   caminos.add((ArrayList)camino.clone());
                   camino.remove(camino.size()-1);
                   //ans = true;
                }else{//es cero
                    mat[i][j]=1;
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    camino.add(pair);
                    
                    todosLosCaminos(i-1,j,mat,caminos,camino);//up
                    todosLosCaminos(i,j+1,mat,caminos,camino);//rigth
                    todosLosCaminos(i+1,j,mat,caminos,camino);//down                            
                    todosLosCaminos(i,j-1,mat,caminos,camino);//left
                    
                    camino.remove(camino.size()-1);        
                    mat[i][j] = 0;
                }
            }
        }
        //return ans;
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private boolean posicionValida(int x,int y,int mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
}