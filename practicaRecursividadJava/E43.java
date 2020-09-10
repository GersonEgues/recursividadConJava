
public class E43{
    public int patronAproximacion(String cad,String pat){
        String cadPrim = eliminarRep(cad,cad.charAt(0),1);
        String patPrim = eliminarRep(pat,cad.charAt(0),1);
        System.out.println(cadPrim + " " + patPrim);
        return patron(cadPrim,patPrim,0);
    }
    private int patron(String cad,String pat,int i){
        int cont = 0;
        if(i+pat.length()<=cad.length()){
            cont = (reconocerPat(cad,pat,i,0))?1:0;
            cont += patron(cad,pat,i+1);
        }
        return cont;
    }
    // i = index cad, j = index pat
    private boolean reconocerPat(String cad,String pat,int i,int j){
        boolean same = true;
        if(j<pat.length()){
            same = (cad.charAt(i)==pat.charAt(j))?reconocerPat(cad,pat,i+1,j+1):false;
        }
        return same;
    }
    //---------------------------------------------------------
    private String eliminarRep(String str,char c,int i){
        String ans = "";
        if(i==str.length()-1){
            if(c != str.charAt(i)){
                ans = c+""+str.charAt(i);
            }
        }else{
            if(c != str.charAt(i)){
                ans = c+"";
                ans += eliminarRep(str,str.charAt(i),i+1);
            }else{
                ans += eliminarRep(str,str.charAt(i),i+1);
            }
        }
        return ans;
    }
}
