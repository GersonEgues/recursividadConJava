
public class E42{
    public int patronExacto(String cad,String pat){
        return patron(cad,pat,0);
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
}
