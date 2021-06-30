import java.io.*;
import java.util.*;

public class Words_K_Selection_4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        function(ustr, 0, unique, 0, k, "");
    }

    public static void function(String ustr, int cidx, HashMap<Character, Integer> fmap, int lidx, int k, String asf) {

        if (cidx == k) {
            System.out.println(asf);
            return;
        }
        for (int i = lidx; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            if (fmap.get(ch) > 0) {
                fmap.put(ch, fmap.get(ch) - 1);
                function(ustr, cidx + 1, fmap, i, k, asf + ch);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }
    }
}
