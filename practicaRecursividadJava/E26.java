
public class E26{
    public boolean anbn(String cad){
        int t = cad.length();
        String c1 = cad.substring(0,t/2);
        String c2 = cad.substring(t/2,t);
        return (t%2==0)?iguales(c1,(t/2))&&iguales(c2,(t/2)):false;
    }
    private boolean iguales(String cad,int t){
        boolean igu = true;
        if(t>0){             
            String aux = cad.substring(0,t-1);
            igu = iguales(aux,aux.length());
            if(!aux.equals("")){
                igu = igu && (aux.charAt(aux.length()-1) == cad.charAt(t-1));                
            }
        }
        return igu;
    }
}
