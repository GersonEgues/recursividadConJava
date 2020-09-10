
public class E20{
    public boolean palindromo(String cad){
        return palindromo(0,cad.length()-1,cad);
    }
    private boolean palindromo(int i,int j,String cad){
        boolean pal = true;
        if(i<j){
            if(cad.charAt(i) == cad.charAt(j)){
                pal = palindromo(i+1,j-1,cad);
            }else{
                pal = false;
            }
        }
        return pal;
    }
}
