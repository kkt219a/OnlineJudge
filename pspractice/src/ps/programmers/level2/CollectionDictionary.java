package ps.programmers.level2;

//12:10~12:25  = 15분
public class CollectionDictionary {
    static String wd;
    static int ans = -1;
    static int ok;
    static String[] mo = {"A","E","I","O","U"};
    public int solution(String word) {
        wd = word;
        dfs("");
        return ok;
    }
    public void dfs(String now){
        ans++;
        if(now.equals(wd)){
            ok = ans;
        }else if(now.length()<5){
            for(int i=0;i<mo.length;i++){
                dfs(now+mo[i]);
            }
        }
    }
}