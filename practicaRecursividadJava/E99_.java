
public class E99_{
    public String parmoniosa(int n){
        String ans = "";
        if(n==1){
            //ans = "**\/**";
        }else{
            if(n%2==0){
                //ans = "++\" + parmoniosa(n-1) + "/++";
            }else{
                //ans = "**\" + parmoniosa(n-1) + "/**";
            }
        }
        return ans;
    }
}
