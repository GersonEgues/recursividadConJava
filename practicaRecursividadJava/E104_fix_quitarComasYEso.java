import java.util.HashSet;
import java.util.Iterator;

public class E104_fix_quitarComasYEso{
    public void longi(String str,int longi){
        String nuevo = str.replace(',',' ');
        nuevo = str.replace(';',' ');
        nuevo = str.replace('.',' ');
        
        
        System.out.println(nuevo);
        
        String list[] = nuevo.split(" ");
        HashSet<String> set = new HashSet<>();
        analizar(list,set,0,longi);
        imprimirDatos(set);        
    }
    private void analizar(String list[],HashSet<String> set,int i,int longi){
        if(i<list.length){
            if(list[i].length()>longi)
                set.add(list[i]);
                
            analizar(list,set,i+1,longi);
        }
    }
    private void imprimirDatos(HashSet<String> set){
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
