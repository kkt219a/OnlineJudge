/**
 *
 * [2021 kakao blind recruitment] 신규 아이디 추천 - 45분
 */
public class NewIdReco {
    public String solution(String new_id) {
        String answer = "";
        //1
        StringBuffer sb = new StringBuffer();
        new_id=new_id.toLowerCase();
        //2
        for(int i=0, j=new_id.length();i<j;i++){
            char tmpChar = new_id.charAt(i);
            if(tmpChar=='-'||tmpChar=='_'||tmpChar=='.'||(tmpChar>96&&tmpChar<123)||(tmpChar>47&&tmpChar<58))
                sb.append(tmpChar);
        }
        //3
        new_id = sb.toString();
        sb = new StringBuffer();
        boolean able = false;
        for(int i=0;i<new_id.length();i++){
            char tmpChar = new_id.charAt(i);
            if(tmpChar=='.'&&!able){
                able = true;
                sb.append(tmpChar);
            }else if(tmpChar=='.'&&able){
            }else{
                able=false;
                sb.append(tmpChar);
            }
        }
        //4
        if(sb.charAt(0)=='.')
            sb.deleteCharAt(0);
        if(sb.length()>0) {
            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length() - 1);
        }
        //5
        if(sb.length()==0){
            sb.append("a");
        }
        //6
        if(sb.length()>15){
            sb.delete(15,sb.length());
            if(sb.charAt(sb.length()-1)=='.')
                sb.deleteCharAt(sb.length()-1);
        }
        //7
        if(sb.length()<3){
            for(;sb.length()!=3;){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        answer = sb.toString();
        return answer;
    }

}
