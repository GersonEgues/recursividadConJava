import java.util.ArrayList;

public class E93_BK{ 
    private char mapa1[][] = {{'L','P','L','M','P','P','P','L'}, 
                              {'L','F','F','P','L','P','F','L'},
                              {'L','P','P','M','L','P','P','L'},
                              {'L','F','F','F','F','F','F','L'},
                              {'P','P','P','L','L','P','P','L'},
                              {'P','L','P','P','L','P','P','P'},
                              {'M','L','F','F','L','F','F','F'},
                              {'P','F','P','P','L','P','P','P'},
                              {'F','F','P','F','F','F','F','F'},
                              {'P','P','P','F','L','M','L','P'},
                              {'P','L','L','F','L','P','P','P'},
                              {'F','F','L','F','F','F','F','F'},
                              {'P','L','L','L','F','P','S','P'},
                              {'P','L','P','P','F','M','P','P'},
                              {'P','L','M','P','F','L','L','L'}};
                              
    private char mapa2[][] = {{'L','L','M'},
                              {'F','P','F'},
                              {'F','S','L'},
                              {'P','P','P'}};                          
    public void quesosFrescos(){ 
        int caminoQueso[] = new int[1];
        int contQueso[] = new int[1];
        ArrayList<Character> camino = new ArrayList<>();
        ArrayList<Character> caminoMasCorto = new ArrayList<>();
        llenar(mapa1,caminoMasCorto);
        caminar(0,0,mapa1,caminoQueso,contQueso,camino,caminoMasCorto,'I');
        System.out.println(caminoMasCorto);
        System.out.println(caminoQueso[0]); 
    }
    private void caminar(int i,int j,char mat[][],int caminoQueso[],int contQueso[],ArrayList<Character> camino,ArrayList<Character> caminoMasCorto,char ant){
        if(posicionValida(i,j,mat)){
            char c = mat[i][j];
            if(c!='P' && c!='X'){
                if(c=='S'){
                    camino.add(ant);
                    if(camino.size() < caminoMasCorto.size()){
                        caminoMasCorto.clear();
                        caminoMasCorto.addAll((ArrayList)camino.clone());
                        caminoQueso[0] = contQueso[0];
                    }
                    camino.remove(camino.size()-1);//***
                }else{
                    if(mat[i][j] == 'F'){
                        contQueso[0] += 1;                        
                    }
                    camino.add(ant); 
                    mat[i][j] = 'X';  
                    
                    caminar(i-1,j,mat,caminoQueso,contQueso,camino,caminoMasCorto,'U');//up
                    caminar(i,j+1,mat,caminoQueso,contQueso,camino,caminoMasCorto,'R');//rigth                        
                    caminar(i+1,j,mat,caminoQueso,contQueso,camino,caminoMasCorto,'D');//down  
                    caminar(i,j-1,mat,caminoQueso,contQueso,camino,caminoMasCorto,'L');//left
                    
                    mat[i][j] = c;
                    
                    if(c=='F'){
                        contQueso[0] -= 1;
                    }
                    camino.remove(camino.size()-1);
                }
            }
        } 
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private boolean posicionValida(int x,int y,char mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
    private void llenar(char mat[][],ArrayList<Character> sec){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                sec.add('C');
            }
        }
    } 
} 
