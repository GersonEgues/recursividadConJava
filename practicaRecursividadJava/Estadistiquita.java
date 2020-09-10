
public class Estadistiquita{
    private int datos[] = {38,51,32,65,25,28,34,12,29,43,
                           71,62,50,37, 8,24,19,47,81,53,
                           55,38,46,16,72,64,61,33,59,21,
                           13,92,37,43,58,52,88,27,74,66,
                           63,28,36,19,56,84,38, 6,42,50,
                           98,51,62, 3,17,43,47,54,58,26};
                           
    private double datos2[] = {20.10, 20.80, 22.60, 21.90, 22.00, 20.70, 20.90, 25.00, 22.20, 22.80,
                               19.50, 25.30, 20.70, 22.50, 21.20, 23.80, 23.30, 21.00, 22.90, 23.50,
                               21.80, 23.70, 20.30, 23.60, 19.00, 25.10, 25.00, 19.50, 24.10, 24.20,
                               23.90, 21.30, 21.50, 23.10, 19.90, 24.40, 24.10, 19.80, 23.90, 22.80,
                               30.70, 19.70, 24.20, 23.80, 20.60, 23.80, 24.30, 21.10, 20.90, 21.60};
    
    public int getCardEnIntervalo(int inf,int sup){
        int ans = 0;
        for(int i=0;i<datos.length;i++){
            if(datos[i]>=inf && datos[i]<sup){
                ans +=1;
            }
        }
        return ans;
    }
    public int getCardEnIntervalo2(double inf,double sup){
        int ans = 0;
        for(int i=0;i<datos2.length;i++){
            if(datos2[i]>=inf && datos2[i]<sup){
                ans +=1;
            }
        }
        return ans;
    }
}
