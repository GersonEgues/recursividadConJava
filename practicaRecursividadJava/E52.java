import java.util.ArrayList;

public class E52{    
    public ArrayList<Integer> mensajes(int x){
        ArrayList<Integer> sms = mensajes2(x);
        System.out.println(sms);
        return sms;
    }
    private ArrayList<Integer> mensajes2(int x){
        ArrayList<Integer> ans = new ArrayList<>();
        if(x==1){
            ans.add(1);
        }else{
            ans.add(x);
            ans.addAll(mensajes2((x%2==0)?x/2:(x*3)+1));
        }
        return ans;
    }
}
