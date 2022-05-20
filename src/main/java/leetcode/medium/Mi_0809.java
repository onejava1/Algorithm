package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 生成括号 采用递归 + 树的生成来做
public class Mi_0809 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("",0,0,n);
        return res;

    }
    private void dfs(String paths,int left,int right,int n){
        if(left>n || right>left) {return;}
        if(paths.length()==2*n){
            res.add(new String(paths));
            return ;
        }
        dfs(paths+"(",left+1,right,n);
        dfs(paths+")",left,right+1,n);
    }

}
