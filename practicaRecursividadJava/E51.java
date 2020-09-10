
public class E51{
    private int mat[][] = {{6,4,2,6,5,3},
                           {2,4,4,6,7,9},
                           {1,5,6,7,2,3},
                           {5,6,3,4,2,1},
                           {1,8,9,3,2,0}
                          };       
    public void rotarDerecha(int n){
          int nRot[] = new int[mat.length];
          get_nRot(nRot,n,0);//obtener las rotaciones
          /*for(int i=0;i<nRot.length;i++){
              System.out.print(nRot[i]+" ");
          }
          System.out.println();*/
          int nmat[][] = rotarMatriz(mat,nRot,new int[mat.length][mat[0].length],0);
          print(nmat);
    }
    private void get_nRot(int nRot[],int n,int i){
        if(i<nRot.length){
            nRot[i] = getSuma(n,mat.length)%mat[0].length;
            get_nRot(nRot,n-1,i+1);
        }
    }
    private int getSuma(int n,int desc){
        int suma = 0;
        if(n>0){
            suma = n%mat[0].length + getSuma(n-desc,desc); 
        }
        return suma;
    }
    private int[][] rotarMatriz(int mat[][],int nRot[],int matRot[][],int i){
        if(i<mat.length){
            rotarMatriz2(mat,nRot,matRot,i,0);
            rotarMatriz(mat,nRot,matRot,i+1);
        }
        return matRot;
    }
    private void rotarMatriz2(int mat[][],int nRot[],int matRot[][],int i,int j){//i fila, j columna
        if(j<mat[0].length){
            int index = j-nRot[i];
            int tamCol = mat[0].length;
            matRot[i][j] = (index>=0)?mat[i][index]:mat[i][tamCol+index];
            rotarMatriz2(mat,nRot,matRot,i,j+1);
        }
    }
    private void print(int nmat[][]){
        for(int i=0;i<nmat.length;i++){
            for(int j=0;j<nmat[0].length;j++){
                System.out.print(nmat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
