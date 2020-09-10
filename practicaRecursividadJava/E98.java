import java.util.ArrayList;

public class E98{
    public ArrayList<Integer> getMejorLoma(int lomas[],int p){
        ArrayList<Integer> lomaMax = new ArrayList<>();        
        getLomas(lomas,lomaMax,0,p);
        System.out.println(lomaMax);
        return lomaMax;
    }
    private void getLomas(int lomas[],ArrayList<Integer> max,int i,int p){
        if(i!=lomas.length-1){
            ArrayList<Integer> ls = new ArrayList<>(); 
            ArrayList<Integer> lb = new ArrayList<>();
            int index1 = getLomaSubida(i,lomas,ls);
            int index2 = getLomaBajada(index1,lomas,lb);   
            ls.addAll(lb); 
            if(cumpleP(ls,p,0)){
                if(ls.size()>max.size()){
                    max.clear();
                    max.addAll((ArrayList)ls.clone());
                }                
            }            
            getLomas(lomas,max,index2,p);
        }
    }
    private int getLomaSubida(int i,int lomas[],ArrayList<Integer> ans){
        int index = 0; 
        if(lomas[i]<=lomas[i+1]){
            ans.add(lomas[i]);
            index = getLomaSubida(i+1,lomas,ans); 
        }else{
            ans.add(lomas[i]);
            index = i+1;
        }
        return index;
    }
    private int getLomaBajada(int i,int lomas[],ArrayList<Integer> ans){
        int index = 0;
        if(i+1<lomas.length){
            if(lomas[i]>=lomas[i+1]){
                ans.add(lomas[i]);               
                index = getLomaBajada(i+1,lomas,ans); 
            }else{  
                ans.add(lomas[i]);
                index = i;
            }
        }else{
            ans.add(lomas[i]);
            index = i;
        }        
        return index;
    }
    private boolean cumpleP(ArrayList<Integer> sec,int p,int i){
        boolean ans = true;
        if(i+1<sec.size()){
            int a = sec.get(i);
            int b = sec.get(i+1);
            int r = Math.abs(a-b);
            ans = r<p && cumpleP(sec,p,i+1);
        }
        return ans;
    }
}