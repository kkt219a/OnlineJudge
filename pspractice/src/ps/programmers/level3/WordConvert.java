package ps.programmers.level3;

//깊이/너비 우선 탐색(DFS/BFS) - 단어 변환
//23:04~23:23
public class WordConvert {
    static String[] wordList;
    static boolean[] visited;
    static String targets;
    static int size;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        wordList = words;
        size = words.length;
        visited = new boolean[size];
        targets = target;
        dfs(begin,0);
        if(answer==Integer.MAX_VALUE) answer = 0;
        return answer;
    }
    public void dfs(String begin, int depth){
        if(begin.equals(targets)){
            answer = Math.min(answer,depth);
        }else{
            for(int i=0;i<size;i++){
                int beginSize = begin.length();
                int wordListSize = wordList[i].length();
                if(beginSize == wordListSize) {
                    int pass = 0;
                    for (int j = 0; j < beginSize; j++) {
                        if(begin.charAt(j)!=wordList[i].charAt(j)){
                            pass++;
                        }
                    }
                    if (!visited[i]&&pass==1) {
                        visited[i] = true;
                        dfs(wordList[i], depth + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }

}
