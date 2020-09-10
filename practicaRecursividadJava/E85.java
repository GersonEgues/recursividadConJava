/**
 * la respuesta de ejercicio esta mal, hay un "t" demas
 * 
 * st   s  una soria    de mieo,     las ltas   dsaparcn    in  abero   y son asenadas   r
 * esta es una historia de misterio, las letras desaparecen sin saberlo y son asesinadas por
 * ea   e      hti         stri          er     eee         s   sl            is         po
 *
 * respuesta correcta = eaehtistriereeesslispo 
   */
public class E85{
    public String letrasFaltantes(String strVirus,String strBackup){
        String virus[] = strVirus.split(" ");
        String backup[] = strBackup.split(" ");
        String str = letras(virus,backup,0);
        System.out.println(str);
        return str;
    }
    private String letras(String virus[],String backup[],int i){
        String ans = "";
        if(i<backup.length){
            ans = analizar(virus[i],backup[i],0) + letras(virus,backup,i+1);
        }
        return ans;
    }
    private String analizar(String v,String b,int i){
        String ans = "";
        if(i<b.length()){
            if(v.contains(b.charAt(i)+"")){
                String auxV = eliminar(v,b.charAt(i),0);
                ans = analizar(auxV,b,i+1);
            }else{
                ans = b.charAt(i) + analizar(v,b,i+1);
            }
        }
        return ans;
    }
    private String eliminar(String v,char c,int i){
        String ans = "";
        if(i < v.length()){
            if(v.charAt(i) == c){
                ans = eliminar(v,'\n',i+1);
            }else{
                ans = v.charAt(i) + eliminar(v,c,i+1);
            }
        }
        return ans;
    }
}
