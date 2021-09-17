package ps.programmers.dontknow;

public class Two {
    public static int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        String zinsuu = zinsu(n, k);
        String[] split = zinsuu.split("0");
        for(int i=0;i< split.length;i++){
            if(!split[i].isBlank()){
                if(isPrimer(split[i])){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static String zinsu(int n, int k){
        String val="";
        while(n>0){
            val = (n%k) + val;
            n /= k;
        }
        return val;
    }

    public static boolean isPrimer(String nn){
        if(nn.contains("0")){
            return false;
        }
        long n = Long.parseLong(nn);
        if(n==1)
            return false;
        for(long i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(999999,10));
    }
}
