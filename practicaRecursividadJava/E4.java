import java.util.ArrayList;

public class E4 {
   public ArrayList<Integer> factoresPrimos(int n){
       return factoresPrimos(2,n);
   }
   private ArrayList<Integer> factoresPrimos(int i, int n){
       ArrayList<Integer> fp = new ArrayList<Integer>();
       if(i<n){
           if(n%i==0 && primo(i)){
               fp.add(i);
           }
           fp.addAll(factoresPrimos(i+1,n));
       }
       return fp;
   }
   //--------------------------------------------------------
   private boolean primo(int n){
       return primo(n,n/2,2);
   }
   private boolean primo(int n,int lim,int i){
       boolean ans = true;
       if(i<=lim){
           if(n%i == 0){
              ans = false; 
           }else{
              ans = primo(n,lim, i+1);
           }
       }
       return ans;
   }
}
