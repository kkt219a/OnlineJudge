package ps.programmers.level1;

//14분
public class LeastRectangle {
    public int solution(int[][] sizes) {
        int wid=-1, hei = -1;
        for(int i=0;i<sizes.length;i++){
            int tmpW = Math.max(wid,sizes[i][0]);
            int tmpH = Math.max(hei,sizes[i][1]);
            int tmpW2 = Math.max(wid,sizes[i][1]);
            int tmpH2 = Math.max(hei,sizes[i][0]);
            if(tmpW*tmpH<=tmpW2*tmpH2){
                wid = tmpW; hei = tmpH;
            }else{
                wid = tmpW2; hei = tmpH2;
            }

        }
        return wid*hei;
    }
}
