package leetcode.string;

public class RationalEqual {
    public boolean isRationalEqual(String S, String T) {
        String SLong = LongRational(S);
        //System.out.println(SLong);
        String TLong = LongRational(T);
       // System.out.println(TLong);
        String SL= toLongS(SLong);
        String TL = toLongS(TLong);
        if(SL.equals(TL)){
            return true;
        }else
            return false;
    }

    private String toLongS(String s) {
        while(s.length()<20)
        {
            s+="0";
        }
        return s;
    }

    private String LongRational(String s) {
        if(s.indexOf(".")==-1)
        {
            s+=".0";
            return s;
        }
        if(s.indexOf("(")==-1)
        {
            String x = s.substring(s.indexOf(".")+1,s.length());
            if(x.length()==0){
                s+="0";
            }
            return s;
        }
        String z =s.substring(0,s.indexOf("."));
        String x = s.substring(s.indexOf(".")+1,s.indexOf("("));
        String h = s.substring(s.indexOf("(")+1,s.indexOf(")"));
       // System.out.println(z+" "+x+" "+h);
        Integer hi =Integer.parseInt(h)+1;
        if(hi.toString().length()>h.length())
        {
            Integer xi;
            if(x.length()==0){
                 xi =hi;
            }else {
                //0.08(9) 过不了
                 xi = Integer.parseInt(x) + 1;
            }
            if(xi.toString().length()>x.length())
            {
                Integer zi =Integer.parseInt(z)+1;
                x=xi.toString().substring(1,xi.toString().length());
                z=zi.toString();
            }else{
                x=xi.toString();
            }
            String sLong =z+"."+x;
            return sLong;
        }
        String mutiH = h;
        while (mutiH.length()<20)
        {
            mutiH+=h;
        }
        String sLong =z+"."+x+mutiH;
        return sLong.substring(0,20);
    }
}
