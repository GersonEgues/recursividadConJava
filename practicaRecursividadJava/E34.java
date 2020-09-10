import java.util.ArrayList;
public class E34{
    public ArrayList<Integer> subsecuenciaMasLarga(int a[]){
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(a[0]);
        return subsequencia(a,1,lista,aux);
    }
    private ArrayList<Integer> subsequencia(int a[],int i,ArrayList<Integer> lista,ArrayList<Integer> aux){
        if(i<a.length){            
            if(aux.get(aux.size()-1) >= a[i]){
                aux.add(a[i]);
                lista = subsequencia(a,i+1,lista,aux);
            }else{
                if(aux.size() > lista.size()){
                    lista = (ArrayList)aux.clone();
                } 
                aux.clear();
                aux.add(a[i]);
                lista = subsequencia(a,i+1,lista,aux);
            }
        }else{
            if(aux.size() > lista.size()){
                    lista = (ArrayList)aux.clone();
            }
        } 
        return lista;
    } 
    private ArrayList<Integer> copiar(ArrayList<Integer> lista){
        ArrayList<Integer> ans = new ArrayList<>();
        ans = (ArrayList)lista.clone();
        
        return ans;
    }
}