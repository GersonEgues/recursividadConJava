import java.util.ArrayList;
/**
 * {1,2,3}
 * 3P3
 * 1,2,3
 * 1,3,2
 * 2,1,3
 * 2,3,1
 * 3,1,2
 * 3,2,1
 * 
 * 3P2
 * 1,2
 * 1,3
 * 2,1
 * 2,3
 * 3,1
 * 3,2
 */
public class Permutaciones_nPn{
   public void permutacioness(int datos[]){
       ArrayList<ArrayList<Integer>> per = permutaciones_nPn(datos,0);
       System.out.println(per);
       System.out.println(per.size());
   }
   private ArrayList<ArrayList<Integer>> permutaciones_nPn(int datos[],int i){
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       if(i<datos.length){
          int aux[] = getDatos(datos,i,new int[datos.length-1],0,0);
          ArrayList<ArrayList<Integer>> per = permutaciones(aux);
          mix(datos[i],per,0); 
          ans.addAll(per);
          ans.addAll(permutaciones_nPn(datos,i+1));
      }
      return ans;
   }
   private void mix(int n,ArrayList<ArrayList<Integer>> per,int i){
       if(i<per.size()){
           per.get(i).add(0,n);
           mix(n,per,i+1);
       }
   }
   private ArrayList<ArrayList<Integer>> permutaciones(int datos[]){
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       if(datos.length==2){
           ArrayList<Integer> p1 = new ArrayList<>();
           ArrayList<Integer> p2 = new ArrayList<>();
           p1.add(datos[0]);
           p1.add(datos[1]);
           p2.add(datos[1]);
           p2.add(datos[0]);
           ans.add(p1);
           ans.add(p2);
       }else{
           ans = permutaciones_nPn(datos,0);
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
