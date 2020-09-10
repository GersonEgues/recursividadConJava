import java.util.ArrayList;

public class E48{
    public int subcadenaMasLarga(String cad,String pat){
        int frecuencia[] = new int[100];
        if(cad.length()<pat.length()){            
            return 0; 
        }else{
            String cadenaContraida = contraer(cad.charAt(0)+"",cad,cad.charAt(0),1,frecuencia,0);// AABB -> AB
            /*System.out.println(cadenaContraida);
            for(int i=0;i<100;i++){
                if(frecuencia[i]!=0){
                   System.out.print(frecuencia[i]); 
                }else
                   break;
            }
            System.out.println();*/
            return cadenaLarga(cadenaContraida,0,pat,frecuencia);
        }
    }
    private int cadenaLarga(String cad,int j,String pat,int frec[]){
        int max = 0;
        if(j+pat.length()<=cad.length()){
            int aux = getTamanioPatron(0,cad,j,pat,0,frec);            
            max = cadenaLarga(cad,j+1,pat,frec);
            if(aux>max){
                max = aux;
            }
        }
        return max;
    }
    private int getTamanioPatron(int suma,String cad,int j,String pat,int k,int frecuencia[]){
        if(k<pat.length()){
            if(cad.charAt(j)==pat.charAt(k)){
                suma += frecuencia[j];
                suma = getTamanioPatron(suma,cad,j+1,pat,k+1,frecuencia);
            }else{
                suma = -1;
            }
        }
        return suma;
    }
    private String contraer(String ans,String cad,char c,int i,int[] frec,int j){ 
        if(i==cad.length()-1){
            if(c == cad.charAt(i)){
                frec[j] += 2;                
            }else{
                frec[j] += 1;
                frec[j+1] = 1;
                ans += cad.charAt(i)+"";
            }
        }else{
            if(c == cad.charAt(i)){
                frec[j] +=1;
                ans = contraer(ans,cad,cad.charAt(i),i+1,frec,j);
            }else{
                frec[j] += 1;
                ans += cad.charAt(i)+"";
                ans = contraer(ans,cad,cad.charAt(i),i+1,frec,j+1);
            }
        }
        return ans;
    }
}