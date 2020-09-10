import java.util.ArrayList;

public class E86_KBots_BK{
    private char mapa1[][] = {{'P','P','P','P','P','M','P','P','M','M'},
                              {'P','E','S','S','S','S','M','S','S','P'},
                              {'S','S','S','P','P','P','P','S','S','S'},
                              {'S','M','S','S','P','P','P','M','S','M'}, 
                              {'S','S','S','S','S','D','S','S','M','S'},
                              {'P','P','P','S','S','S','S','M','S','S'},
                              {'S','S','M','S','M','S','M','S','M','S'}};
    //no hay paso seguro    
    private char mapa2[][] = {{'P','P','P','P','P','M','P','P','M','M'},
                              {'P','E','S','P','S','S','M','S','S','P'},
                              {'S','S','P','P','P','P','P','S','S','S'},
                              {'S','M','M','M','P','P','P','M','S','M'}, 
                              {'S','M','D','S','P','P','S','S','M','S'},
                              {'P','P','P','P','P','S','S','M','S','S'},
                              {'S','S','M','S','M','S','M','S','M','S'}};                              
    public void documento(){
        ArrayList<ArrayList<Character>> ans = new ArrayList<>();
        boolean encontroSinMinas = documento(1,1,mapa2,ans,'I');
        if(!encontroSinMinas){
            ans.clear();
            llenarMinas(ans,mapa2.length*mapa2[0].length );
            ArrayList<ArrayList<Character>> camino = new ArrayList<>();
            documentoConMinas(1,1,mapa2,ans,camino,'I');
        }
        System.out.println(ans);
    }
    private boolean documento(int i,int j,char mat[][],ArrayList<ArrayList<Character>> ans,char a){//a antecesor
        boolean encontro = false;
        if(posicionValida(i,j,mat)){
            char c = mat[i][j];
            if(c!='P' && c!='M' && c!='X'){
                if(c=='D'){
                    ArrayList<Character> aux = new ArrayList<>();
                    aux.add(a);
                    aux.add(c);
                    ans.add(aux);
                    encontro = true;
                }else{//c = E  || c = S
                    mat[i][j] = 'X';
                    
                    ArrayList<Character> aux = new ArrayList<>();
                    aux.add(a);
                    aux.add(c);
                    ans.add(aux);
                    
                    encontro = documento(i-1,j,mat,ans,'U');//up
                    if(!encontro){                                             
                        encontro = documento(i,j+1,mat,ans,'R');//rigth                        
                        if(!encontro){                            
                            encontro = documento(i+1,j,mat,ans,'D');//down  
                            if(!encontro){
                                encontro = documento(i,j-1,mat,ans,'L');//left                                
                            }
                        }
                    }
                    
                    if(!encontro){
                        ans.remove(ans.size()-1);
                    }
                    mat[i][j] = c;
                }
            }
        }
        return encontro;
    }  
    private void documentoConMinas(int i,int j,char mat[][],ArrayList<ArrayList<Character>> ans,ArrayList<ArrayList<Character>> camino,char a){//a antecesor
        if(posicionValida(i,j,mat)){
            char c = mat[i][j];
            if(c!='P' && c!='X'){
                if(c=='D'){
                    ArrayList<Character> aux = new ArrayList<>();
                    aux.add(a);
                    aux.add(c); 
                    camino.add(aux);                    
                    if(numMinas(camino,0)<numMinas(ans,0)){//ans < camino
                        ans.clear();
                        ans.addAll((ArrayList)camino.clone());                        
                    }
                    camino.remove(camino.size()-1);
                }else{//c = E  || c = S
                    mat[i][j] = 'X';                    
                    ArrayList<Character> aux = new ArrayList<>();
                    aux.add(a);
                    aux.add(c);
                    camino.add(aux);                    
                    documentoConMinas(i-1,j,mat,ans,camino,'U');//up
                    documentoConMinas(i,j+1,mat,ans,camino,'R');//rigth                        
                    documentoConMinas(i+1,j,mat,ans,camino,'D');//down  
                    documentoConMinas(i,j-1,mat,ans,camino,'L');//left                                                    
                    camino.remove(camino.size()-1);                     
                    mat[i][j] = c;
                }
            }
        }
    }      
    private int numMinas(ArrayList<ArrayList<Character>> sec,int k){
        int suma = 0;
        for(int i=0;i<sec.size();i++){
            if(sec.get(i).get(1)=='M'){
                suma+=1;
            }
        }
        return suma;
    }
    private void llenarMinas(ArrayList<ArrayList<Character>> ans,int n){
        for(int i=0;i<n;i++){
            ArrayList<Character> aux = new ArrayList<>();
            aux.add('A');
            aux.add('M');
            ans.add(aux);
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    private boolean posicionValida(int x,int y,char mat[][]){
        return (x>=0 && y>=0 && x<mat.length && y<mat[0].length);
    }
}
