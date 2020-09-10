
public class E28{
    // [a]
    public boolean prefijo(String c1,String c2){
        return prefijo(c1,c2,0);
    }
    private boolean prefijo(String c1,String c2,int i){
        boolean res = true;
        if(i<c1.length()){
            if(c2.charAt(i) != c1.charAt(i)){
                res = false;
            }else{
                res = prefijo(c1,c2,i+1);
            }
        }
        return res;
    }
    //-------------------------------------------------------
    // [b]
    public boolean sufijo(String c1,String c2){
        return sufijo(c1,c2,c1.length()-1,c2.length()-1);
    }
    private boolean sufijo(String c1,String c2,int i,int j){
        boolean res = true;
        if(i>=0){
            if(c1.charAt(i) != c2.charAt(j)){
                res = false;
            }else{
                res = sufijo(c1,c2,i-1,j-1);
            }
        }
        return res;
    }
}