
public class E67{
    public boolean tautograma(String cad){
        cad = cad.toLowerCase();
        return tautograma(cad.charAt(0),cad,1);
    }
    private boolean tautograma(char c,String cad,int i){
        boolean ans = true;
        if(i<cad.length()){
            if(cad.charAt(i)==' '){
                if(i+1<cad.length()){
                    if(cad.charAt(i+1) == (int)c){
                        ans = true && tautograma(c,cad,i+2);
                    }else{
                        ans = false;
                    }
                }
            }else{
                ans = tautograma(c,cad,i+1);
            }
        }
        return ans;
    }
}
