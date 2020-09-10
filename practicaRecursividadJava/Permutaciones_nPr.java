
import java.util.ArrayList;
/**
 * {1,2,3}
 * 3P2
 * 1,2
 * 1,3
 * 2,1
 * 2,3
 * 3,1
 * 3,2
 */
public class Permutaciones_nPr{
   public void permutacioness(int datos[],int r){
       ArrayList<ArrayList<Integer>> per = permutaciones_nPn(datos,0,r);
       System.out.println(per);
       System.out.println(per.size());
   }
   private ArrayList<ArrayList<Integer>> permutaciones_nPn(int datos[],int i,int r){
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       if(i<datos.length){
          int aux[] = getDatos(datos,i,new int[datos.length-1],0,0);
          ArrayList<ArrayList<Integer>> per = permutaciones(aux,r-1);
          mix(datos[i],per,0); 
          ans.addAll(per);
          ans.addAll(permutaciones_nPn(datos,i+1,r));
      }
      return ans;
   }
   private void mix(int n,ArrayList<ArrayList<Integer>> per,int i){
       if(i<per.size()){
           per.get(i).add(0,n);
           mix(n,per,i+1);
       }
   }
   private ArrayList<ArrayList<Integer>> permutaciones(int datos[],int r){
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       if(r==1){
           for(int j=0;j<datos.length;j++){
               ArrayList<Integer> aux = new ArrayList<>();
               aux.add(datos[j]);
               ans.add(aux);
           }
       }else{
           ans = permutaciones_nPn(datos,0,r);
       }
       return ans;
   }
   private int[] getDatos(int datos[],int i,int ans[],int j,int k){
       if(j<datos.length){
           if(i!=j){
               ans[k] = datos[j];
               getDatos(datos,i,ans,j+1,k+1);
           }else{
               getDatos(datos,i,ans,j+1,k);
           }
       }
       return ans;
   }
}
