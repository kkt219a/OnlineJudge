package ps.programmers.level1;

//탐욕법(Greedy) - 체육복
// 15:35~16:00 = 15분
public class GymClothes {
    int[] students;
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        students = new int[n];
        for(int i=0;i<n;students[i++]=1);
        for (int i : lost) {students[i-1]-=1;}
        for (int i : reserve) {students[i-1]+=1;}
        for(int i=0;i<n;i++){
            if(students[i]==2){
                if(i!=0&&students[i-1]==0){
                    students[i]-=1;
                    students[i-1]+=1;
                }else if(i!=n-1&&students[i+1]==0){
                    students[i]-=1;
                    students[i+1]+=1;
                }
            }
        }
        for (int student : students) {
            if(student!=0) answer++;
        }
        return answer;
    }

}
