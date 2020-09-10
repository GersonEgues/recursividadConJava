
public class E54{
    private char cadena[] = {'s','m','r','t','a','e','i','v','u','r','w','f','g','s','r','y','f','z','e','u','a','t','j'};
    
    public String saltarin(int ini,String cad){//i = index donde iniciamos
        String ans = saltarin(ini,cad,0);
        System.out.println(ans);
        return ans;
    }
    private String saltarin(int i,String cad,int cont){
        String ans = "";
        if(cont!=cad.length()-1){
            if(cadena[i] != cad.charAt(cont)){
                int n1 = buscarAdelante(cad.charAt(cont),i);
                int n2 = buscarAtraz(cad.charAt(cont),i);
                if(n1!=-1 && n2!=-1){                   
                   if(n1-i <= i-n2){
                       ans = (n1-i) + "adelante, " + saltarin(n1,cad,cont);
                   }else{
                       ans = (i-n2) + "atraz, " + saltarin(n2,cad,cont);
                   }
                }else if(n1!=-1){
                    ans = (n1-i) + "adelante, " + saltarin(n1,cad,cont);
                }else if(n2!=-1){//n2!=-1
                    ans = (i-n2) + "atraz, " + saltarin(n2,cad,cont); 
                }else{
                    ans = "imposible, ";
                }
            }else{
                int n1 = buscarAdelante(cad.charAt(cont+1),i);
                int n2 = buscarAtraz(cad.charAt(cont+1),i);
                if(n1!=-1 && n2!=-1){                   
                   if(n1-i <= i-n2){
                       ans = (n1-i) + "adelante, " + saltarin(n1,cad,cont+1);
                   }else{
                       ans = (i-n2) + "atraz, " + saltarin(n2,cad,cont+1);
                   }
                }else if(n1!=-1){
                    ans = (n1-i) + "adelante, " + saltarin(n1,cad,cont+1);
                }else if(n2!=-1){//n2!=-1
                    ans = (i-n2) + "atraz, " + saltarin(n2,cad,cont+1);
                }else{
                    ans = "imposible, ";
                }
            }
        }
        return ans;
    }
    private int buscarAdelante(char c,int i){
        int ans = -1;
        if(i<cadena.length){
            if(c == cadena[i]){
                ans = i;
            }else{
                ans = buscarAdelante(c,i+1); 
            }
        }
        return ans;
    }
    private int buscarAtraz(char c,int i){
        int ans = -1;
        if(i>=0){
            if(c == cadena[i]){
                ans = i;
            }else{
                ans = buscarAtraz(c,i-1); 
            }
        }
        return ans;
    }
}