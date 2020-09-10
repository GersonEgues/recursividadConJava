
public class E47{
    public String carasChinas(int n){
        String china = ""; 
        if(n==1){
            china = "(-.-)";
        }else{
            china = "(-." + carasChinas(n-1) + ".-)";
        }
        return china;
    }
}
