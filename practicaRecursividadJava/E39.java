
public class E39{
    public String cadenaReducida(String cad){
        return cr(cad,1,cad.charAt(0),1);
    }
    private String cr(String cad,int index,char c,int con){
        String ans = "";
        if(!(index<cad.length())){
            ans = c+"" + con;
        }else{
            if(c!=cad.charAt(index)){
                ans = c+""+con;
                if(index+1<cad.length()){
                    ans += cr(cad,index+1,cad.charAt(index),1);
                }else{
                    ans += cad.charAt(index)+""+1; 
                }
            }else{
                ans += cr(cad,index+1,c,con+1);
            }
        }
        return ans;
    }
}
