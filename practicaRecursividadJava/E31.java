/*
/**
 recibe 2 entradas, laparte entera y la decimal, la decimal entra como un entero
 es decir 0.30 cts = 30 cvts
 solo admite decimales de 2 digitos.
 */
public class E31{
    private int billetes[] = {100,50,20,10,5,2};
    private int monedas[] = {100,50,25,10,5,1};
    public String detalle(int entero,int ctvs){
        String ans = "";
        if(entero < billetes[5]){//voy a por monedas           
               ans = detalleCtvs(entero * 100 + ctvs);
        }else{
            if(entero>=billetes[0]){//100
                ans = billetes[0] + "$ ";
                ans += detalle(entero-billetes[0],ctvs);
            }else if(entero>=billetes[1]){//50
                ans = billetes[1] + "$ ";
                ans += detalle(entero-billetes[1],ctvs);
            }else if(entero>=billetes[2]){//20
                ans = billetes[2] + "$ ";
                ans += detalle(entero-billetes[2],ctvs);
            }else if(entero>=billetes[3]){//10
                ans = billetes[3] + "$ ";
                ans += detalle(entero-billetes[3],ctvs);
            }else if(entero>=billetes[4]){//5
                ans = billetes[4] + "$ ";
                ans += detalle(entero-billetes[4],ctvs);
            }else if(entero>=billetes[5]){//2
                ans = billetes[5] + "$ ";
                ans += detalle(entero-billetes[5],ctvs);
            }                        
        }
        return ans;
    }
    /**
       1 = 100
       0.50 = 50 -> 0.50*100 = 50.0
       0.25 = 25 -> 
    */
    private String detalleCtvs(int ctvs){
        String ans = "";
        if(ctvs!=0){
            if(ctvs>=monedas[0]){//100
                ans = monedas[0]/100.0 + "Ctvs ";
                ans += detalleCtvs(ctvs-monedas[0]);
            }else if(ctvs>=monedas[1]){//50
                ans = monedas[1]/100.0 + "Ctvs ";
                ans += detalleCtvs(ctvs-monedas[1]);
            }else if(ctvs>=monedas[2]){//25
                ans = monedas[2]/100.0 + "Ctvs ";
                ans += detalleCtvs(ctvs-monedas[2]);
            }else if(ctvs>=monedas[3]){//10
                ans = monedas[3]/100.0 + "Ctvs ";
                ans += detalleCtvs(ctvs-monedas[3]);
            }else if(ctvs>=monedas[4]){//5
                ans = monedas[4]/100.0 + "Ctvs ";
                ans += detalleCtvs(ctvs-monedas[4]);
            }else if(ctvs>=monedas[5]){//1
                ans = monedas[5]/100.0 + "Ctvs ";
                ans += detalleCtvs(ctvs-monedas[5]);
            }     
        }
        return ans;
    }
}
       