
public class E49{
    public int numOndas(String cad){
        String cadContraida = contraer(cad.charAt(0)+"",cad,1);// AABB -> AB        
        return cadContraida.length() - 2;
    }
    private String contraer(String ans,String cad,int i){
        if(i==cad.length()-1){
            if(cad.charAt(i-1)!=cad.charAt(i)){
                ans+=cad.charAt(i)+"";
            }
        }else{
            if(cad.charAt(i-1) != cad.charAt(i)){
                ans+=cad.charAt(i)+"";
                ans = contraer(ans,cad,i+1);
            }else{
                ans = contraer(ans,cad,i+1);
            }
        }
        return ans;
    }
}