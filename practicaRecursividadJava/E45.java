import java.util.HashMap;

public class E45{
    //una unica regla, la separacion entre palabras debe ser unicamente de un espacio
    public void frecuencia(String cad){        
        HashMap<String,Integer> map = new HashMap<>();
        frecuencia(cad,0,map);
        System.out.println(map);
    }
    private void frecuencia(String cad,int i,HashMap<String,Integer> map){
        if(i<cad.length()){ 
            String subcadena = extraerSubcadena(cad,i);
            if(map.containsKey(subcadena)){
                int cont = map.get(subcadena);
                map.remove(subcadena);
                map.put(subcadena, cont+1);
            }else{
                map.put(subcadena,1);
            }
            i += subcadena.length()+1;
            frecuencia(cad,i,map);
        }
    } 
    private String extraerSubcadena(String cad,int i){ 
        String subcadena = "";
        if(i<cad.length()){
            if(cad.charAt(i) != ' '){
                subcadena =  cad.charAt(i)+"";
                subcadena += extraerSubcadena(cad,i+1);
            }
        }
        return subcadena;
    }     
}
