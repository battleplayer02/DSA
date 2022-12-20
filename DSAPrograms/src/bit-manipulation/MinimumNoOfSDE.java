import java.util.List;

class MinimumNoOfSDE{
    /**
     * There are skills a particular Developer has you need to employee least number of developer
     * which has all the skills to complete a project.
     * 
     * Leetcode 1125
     */

     // return the list of index developers
     public static List<Integer> solution(List<String> skills,List<List<String>> devSkills){
        List<Integer> sol = new ArrayList<Integer>();
        helper(0, 0, 0, new ArrayList<Integer>(),devSkills,skills.size(),sol);
        return sol;
     }

     public static void helper(int cs,int ssf,int i,List<Integer> ans,List<Listt<String>>devSkills,int nskills,List<Integer>sol){
        if(i == devSkills.length()){
            if(ans.size() == 0 || ans.size()<sol.size()){
                sol = ans;
            }
            return;
        }
        helper(cs, ssf, i+1, ans);
        ans.add(i);
        helper(cs, ssf, i+1, ans);
        ans.remove(ans.size());
     }
}