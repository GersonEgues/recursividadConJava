import java.util.ArrayList;

/**
 * conjunto clausura == nCr (conbinaciones)
 */
public class E74_conjunto_clausura{
    public ArrayList<ArrayList<Integer>> conbinacioness(int datos[],int r){
        ArrayList<ArrayList<Integer>> con = conbinaciones_nCr(datos,r,0);
        System.out.println(con);
        System.out.println(con.size());
        return con;
    }
    private ArrayList<ArrayList<Integer>> conbinaciones_nCr(int datos[],int r,int i){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(i+r<=datos.length){
            int aux[] = getDatos(datos,new int[datos.length-(i+1)],i+1,0);
            ArrayList<ArrayList<Integer>> conb = conbinaciones(aux,r-1);
            mix(datos[i],conb,0);
            ans.addAll(conb);
            ans.addAll(conbinaciones_nCr(datos,r,i+1));
        }
        return ans;
    }
    private ArrayList<ArrayList<Integer>> conbinaciones(int datos[],int r){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(r==1){
            for(int k=0;k<datos.length;k++){
                ArrayList<Integer> aux = new ArrayList<>();
                aux.add(datos[k]);
                ans.add(aux);
            }
        }else{
            ans = conbinaciones_nCr(datos,r,0);
        }
        return ans;
    }
    private void mix(int n,ArrayList<ArrayList<Integer>> con,int i){
       if(i<con.size()){
           con.get(i).add(0,n);
           mix(n,con,i+1);
       }
    }
    private int[] getDatos(int datos[],int ans[],int i,int j){
       if(i<datos.length){
           ans[j] = datos[i];
           getDatos(datos,ans,i+1,j+1);
       }
       return ans;
    }
}
