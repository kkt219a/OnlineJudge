package ps.programmers.level1;

// 2018 KAKAO BLIND RECRUITMENT  - [1차] 비밀지도
// 22:53~23:09 = 16분
public class SecretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i< n;i++){
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            StringBuilder sb = new StringBuilder(s1);
            StringBuilder sb2 = new StringBuilder(s2);

            for(int j=sb.length();j<n;j++,sb.insert(0,"0"));
            for(int j=sb2.length();j<n;j++,sb2.insert(0,"0"));
            answer[i] = "";
            for(int j=0;j<n;j++){
                if(sb.charAt(j)==sb2.charAt(j)&&sb.charAt(j)=='0'){
                    answer[i]+=" ";
                }else{
                    answer[i]+="#";
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(6,new int[]{46, 33, 33, 22, 31, 50},new int[]{27, 56, 19, 14, 14, 10});
    }
}
