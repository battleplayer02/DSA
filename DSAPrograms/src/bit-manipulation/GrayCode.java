import java.util.ArrayList;

class GrayCode{
    public ArrayList<String> grayCode(int n) {
        if(n == 1){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }
        ArrayList<String> rres = grayCode(n-1);
        ArrayList<String> mres = new ArrayList<>();
        for(int i=0;i<rres.size();i++){
            String res = rres.get(i);
            mres.add("0"+res);
        }
        for(int i=rres.size()-1;i>=0;i--){
            String res = rres.get(i);
            mres.add("1"+res);
        }
        return mres;
    }
}