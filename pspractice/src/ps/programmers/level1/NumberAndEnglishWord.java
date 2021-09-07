package ps.programmers.level1;

// 숫자 문자열과 영단어 - 2021 카카오 채용연계형 인턴십
//23:30~23:32 = 2분
public class NumberAndEnglishWord {
    public int solution(String s) {
        return Integer.parseInt(s.replace("zero","0")
                .replace("one","1")
                .replace("two","2")
                .replace("three","3")
                .replace("four","4")
                .replace("five","5")
                .replace("six","6")
                .replace("seven","7")
                .replace("eight","8")
                .replace("nine","9"));
    }
}
