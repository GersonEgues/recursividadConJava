
public class E57{
    public int autocontenciones(int n,int b){
        return autocnt(n,b,0);
    }
    private int autocnt(int n,int b,int i){//n = numero, b = base, i = pot
        int sum = 0;
        if((int)(Math.log10(n)) == (int)(Math.log10(Math.pow(b,i)))){
            if(n == Math.pow(b,i)){
                sum = 1;
            }else{
                sum = -1;
            }            
        }else{
            int p1 = (int)(Math.pow(b,i));
            int pot = ((int)(Math.log10(n)))-((int)(Math.log10(p1)));
            int div = (int)(Math.pow(10,pot));
            int aux = autocnt(n%div,b,i+1); 
            int next = (aux != -1)? aux : -1; 
            if(next!=-1){
                sum = ((n/div) == p1)? 1 + next: -1;
            }else{
                sum = -1;
            }            
        }
        return sum;
    }
}