
public class E94{
    public boolean poemaMatematico(String n,String poema){
        boolean ans = false;
        poema = poema.replace('.',' ');
        poema = poema.replace(',',' ');
        poema = poema.replace(';',' ');
        poema = poema.replace(':',' ');
        String poema2[] = poema.split(" ");
        //System.out.println(n.length());
        //System.out.println(poema2.length);
        return (n.length()==poema2.length)?poemaMatematico(n,poema2,0):false;
    }
    private boolean poemaMatematico(String n,String poema[],int i){
        boolean ans = false;
        int t = Integer.parseInt(""+n.charAt(i));
        if(i==poema.length-1){            
            ans = t == poema[i].length();
        }else{
            ans = t == poema[i].length() && poemaMatematico(n,poema,i+1);
        }
        return ans; 
    }
}
