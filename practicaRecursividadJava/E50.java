
public class E50{
    public String print(String cad){
        int frec[] = new int[100];
        frec[0]=1;
        String cadContraida = contraer(cad.charAt(0)+"",cad,1,frec,0);
        
        /*System.out.println(cad);
        System.out.println(cadContraida);
        for(int i=0;i<cadContraida.length();i++){
            System.out.print(frec[i]);
        } */
        System.out.println();
        
        String aux = dibujar((cadContraida.charAt(0)=='H')?'H':'L',frec[0]);
        String ondas = dibujarOndas(aux,cadContraida,frec,1);
        System.out.println(ondas);
        return ondas;
    }  
    private String dibujarOndas(String ans,String cadena,int frec[],int i){ 
        if(i < cadena.length()){ 
            if(cadena.charAt(i)=='H'){
                ans += "|"+dibujar('H',frec[i]);
            }else{
                ans += "|"+dibujar('L',frec[i]);
            }
            ans = dibujarOndas(ans,cadena,frec,i+1);
        }
        return ans; 
    }
    private String dibujar(char c,int f){
        String ans = "";
        for(int i=0;i<f;i++){
            if(c == 'H'){
                ans += "-";
            }else{
                ans += "_";
            }
        }
        return ans;
    }
    private String contraer(String ans,String cad,int i,int frec[],int k){ 
        if(i==cad.length()-1){ 
            if(cad.charAt(i-1) != cad.charAt(i)){
                ans += cad.charAt(i)+"";
                frec[k+1] = 1;
            }else{
                frec[k]+=1;
            }
        }else{
            if(cad.charAt(i-1) != cad.charAt(i)){
                ans += cad.charAt(i)+"";
                frec[k+1] = 1;
                ans = contraer(ans,cad,i+1,frec,k+1);
            }else{
                frec[k] += 1; 
                ans = contraer(ans,cad,i+1,frec,k);
            }
        } 
        return ans;
    } 
}