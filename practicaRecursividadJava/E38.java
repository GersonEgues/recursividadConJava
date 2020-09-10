import java.util.ArrayList;

public class E38{
    private int cc[] = {1,2,3,4}; 
    public void conjuntoClausura(){
        ArrayList<ArrayList<Integer>> ccl = conCla(0,cc.length+1);
        System.out.println(ccl);
    } 
    private ArrayList<ArrayList<Integer>> conCla(int i,int f){
        ArrayList<ArrayList<Integer>> lista = new ArrayList<ArrayList<Integer>>();
        for(int k=0;k<f;k++){
            lista.addAll(generar(k,0));
        }
        return lista;
    }
    // i = cardinalidad, ini = de donde inicia
    private ArrayList<ArrayList<Integer>> generar(int i,int ini){
        ArrayList<ArrayList<Integer>> lista = new ArrayList<ArrayList<Integer>>();
        if(i==0){
            lista.add(new ArrayList<Integer>());
        }else{
            if(ini<cc.length){
                lista.addAll(generar2(i,ini));
                lista.addAll(generar(i,ini+1)); 
            }
        }
        return lista;
    }
    private ArrayList<ArrayList<Integer>> generar2(int i,int ini){
        ArrayList<ArrayList<Integer>> lista = new ArrayList<ArrayList<Integer>>();
        if(i==1){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(cc[ini]);
            lista.add(ans);
        }else{
            if((ini+(i-1))<cc.length){ 
                ArrayList<ArrayList<Integer>> ans = generar(i-1,ini+1);
                for(int k=0;k<ans.size();k++){
                    ans.get(k).add(0,cc[ini]);
                }
                lista.addAll(ans);
                //lista.addAll(generar2(i,ini+1));                
            }
        }
        return lista;
    }
}