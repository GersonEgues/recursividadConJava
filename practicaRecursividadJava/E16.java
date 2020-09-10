import java.util.ArrayList;

public class E16{
    public ArrayList<Integer> bomba(int n,int b){
        ArrayList<Integer> res = new ArrayList<>();
        if(n>b){
            int n1 = n/b;
            int n2 = n - n1;
            if(n1>b){
                res.addAll(bomba(n1,b));
            }else{
                res.add(n1);
            }
            
            if(n2>b){
                res.addAll(bomba(n2,b));
            }else{
                res.add(n2);
            }
        }else{
            res.add(n);
        }
        return res;
    }
}
