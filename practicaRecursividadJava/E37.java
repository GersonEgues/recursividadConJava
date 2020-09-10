
public class E37{
    private int[][] mat = {{0,0,0,1,1,1,0,0,0},
                           {0,0,1,1,1,1,1,0,0},
                           {0,1,1,1,1,1,1,1,0},
                           {1,1,1,1,1,1,1,1,1}};
    private int[][] matTra = new int[mat[0].length][mat.length];
    public void transponer(){        
        for1(0);
        print();
    }
    private void for1(int f){
        if(f<mat.length){
            for2(f,0);
            for1(f+1);
        }
    }
    private void for2(int f,int c){
        if(c<mat[f].length){
            matTra[c][f] = mat[f][c];
            for2(f,c+1);
        }
    }
    private void print(){
        for(int i=0;i<matTra.length;i++){
            for(int j=0;j<matTra[i].length;j++){
                if(matTra[i][j]==0){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        //System.out.println();
    }
}
