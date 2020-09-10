
public class E17{
    // [a]
    public int numCaracteres(String cad,char c){
        return numCaracteres(cad,c,0);
    }
    private int numCaracteres(String cad,char c,int i){
        int suma=0;
        if(i<cad.length()){
            if(cad.charAt(i) == c){
                suma = 1;
            }
            suma += numCaracteres(cad,c,i+1);
        }
        return suma;
    }
    // [b]
    public String invertido(String cad){
        return invertido(cad,0);
    }
    private String invertido(String cad,int i){
        String inv = "";
        if(i<cad.length()){
            inv = invertido(cad,i+1)+cad.charAt(i);
        }
        return inv;
    }
    // [c]
    public int vocales(String cad){
        return vocales(cad,0);
    }
    private int vocales(String cad,int i){
        int suma = 0;
        if(i<cad.length()){
            char c = cad.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                suma = 1;
            }
            suma += vocales(cad,i+1);
        }
        return suma;
    }
}