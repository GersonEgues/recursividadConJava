
public class E25{
    public String inversoSimple(String cad){
        return invertir(inversoSimple(cad,cad.length()-1),0);
    }
    private String inversoSimple(String cad,int i){
        String inv = "";
        if(i>=0){
            inv = inversoSimple(cad.substring(0,i),i-1);
            if(inv!=""){
                if(inv.charAt(inv.length()-1) != cad.charAt(i)){
                    inv = inv+cad.charAt(i);
                }
            }else{
                inv = cad.charAt(i)+"";
            }
        }
        return inv; 
    }
    private String invertir(String cad,int i){
        String inv = "";
        if(i<cad.length()){
            inv = invertir(cad,i+1) + cad.charAt(i);
        }
        return inv;
    }
}
