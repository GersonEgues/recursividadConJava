import java.util.ArrayList;

public class E88{
   public void noJuntos(String alumnos[],String a1,String a2){
       ArrayList<ArrayList<String>> permutaciones = permutacioness(alumnos);
       eliminarJuntos(permutaciones,a1,a2,0);
       print(permutaciones);
   }
   private void eliminarJuntos(ArrayList<ArrayList<String>> alumnos,String a1,String a2,int i){
       if(i<alumnos.size()){
           if(juntos(alumnos.get(i),a1,a2,0)){
               alumnos.remove(i);
               eliminarJuntos(alumnos,a1,a2,i);
           }else{
               eliminarJuntos(alumnos,a1,a2,i+1);
           }
       }
   }
   private boolean juntos(ArrayList<String> grupo,String a1,String a2,int i){
       boolean ans = false;
       if(i+1<grupo.size()){
           if((grupo.get(i) == a1 && grupo.get(i+1) == a2) || (grupo.get(i) == a2 && grupo.get(i+1) == a1)){
               ans = true;
           }else{
               ans = juntos(grupo,a1,a2,i+1);
           }           
       }
       return ans;
   }
   private void print(ArrayList<ArrayList<String>> permutaciones){
       for(int i=0;i<permutaciones.size();i++){
           System.out.println(permutaciones.get(i));
       }
       System.out.println();
   }
   //----------------------------------------------------------------------------
   //----------------------------------------------------------------------------
   private ArrayList<ArrayList<String>> permutacioness(String datos[]){
       return permutaciones_nPn(datos,0);
   }
   private ArrayList<ArrayList<String>> permutaciones_nPn(String datos[],int i){
      ArrayList<ArrayList<String>> ans = new ArrayList<>();
       if(i<datos.length){
          String aux[] = getDatos(datos,i,new String[datos.length-1],0,0);
          ArrayList<ArrayList<String>> per = permutaciones(aux);
          mix(datos[i],per,0); 
          ans.addAll(per);
          ans.addAll(permutaciones_nPn(datos,i+1));
      }
      return ans;
   }
   private void mix(String n,ArrayList<ArrayList<String>> per,int i){
       if(i<per.size()){
           per.get(i).add(0,n);
           mix(n,per,i+1);
       }
   }
   private ArrayList<ArrayList<String>> permutaciones(String datos[]){
       ArrayList<ArrayList<String>> ans = new ArrayList<>();
       if(datos.length==2){
           ArrayList<String> p1 = new ArrayList<>();
           ArrayList<String> p2 = new ArrayList<>();
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
   private String[] getDatos(String datos[],int i,String ans[],int j,int k){
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
