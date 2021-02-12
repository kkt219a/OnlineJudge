/**
 *
 * [2018 kakao blind recruitment] 비밀지도 -21분
 */
public class SecretMap {

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0;i<n;i++){

            String binaryArr1 = Integer.toBinaryString(arr1[i]);
            String binaryArr2 = Integer.toBinaryString(arr2[i]);
            StringBuffer sb1 = new StringBuffer(binaryArr1);
            StringBuffer sb2 = new StringBuffer(binaryArr2);
            int sb1Leng = sb1.length();
            int sb2Leng = sb2.length();
            for(int j=0;j<n-sb1Leng;sb1.insert(0,"0"),j++);
            for(int j=0;j<n-sb2Leng;sb2.insert(0,"0"),j++);

            String tmpString = "";
            for(int j=0;j<sb1.length();j++){
                if(sb1.charAt(j)=='0'&&sb2.charAt(j)=='0')
                    tmpString+=" ";
                else
                    tmpString+="#";
            }

            answer[i]=tmpString;
        }

        return answer;
    }


}

/**
 * 공백 or 벽(#)
 * 지도1, 지도2 중에 어느 하나라도 벽이면 전체 지도에서도 벽이다
 *
 */

