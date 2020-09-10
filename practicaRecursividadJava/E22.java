
public class E22{
    public void figuras(){
        System.out.println(figuras(1));
    }
    private String figuras(int i){
        String cad = "";
        if(i<10){
            cad = getNumCad(i)+"\n";
            cad += figuras(i+1);
        }
        return cad;
    }
    private String getNumCad(int n){
        String ans = "";
        if(n>=1){
            ans = n + getNumCad(n-1);
        }
        return ans;
    }
}