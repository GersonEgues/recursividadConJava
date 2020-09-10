import java.util.ArrayList;

public class E35{
    public ArrayList<Integer> pascal(int n){
        ArrayList<Integer> ans = pascall(n);
        System.out.println(ans);
        return ans;
    }
    private ArrayList<Integer> pascall(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        if(n==0){
            ans.add(1);
        }else{
            ans = pascall(n-1);
            ans = llenar(ans,new ArrayList<Integer>(),0,1);            
        }
        return ans;
    }
    private ArrayList<Integer> llenar(ArrayList<Integer> a,ArrayList<Integer> a1,int i,int j){
        if(!(j<a.size())){
            a1.add(0,1);
            a1.add(a1.size(),1);
        }else{
            a1.add(a.get(i)+a.get(j));
            a1 = llenar(a,a1,i+1,j+1);
        }
        return a1;
    }
}
