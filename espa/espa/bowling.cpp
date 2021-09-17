//
//  cross.cpp
//  espa
//
//  Created by 김규태 on 2021/09/14.
//

#include <iostream>
#pragma warning(disable:4996)
using namespace std;

int t,num;
int firstNum, secondNum, thirdNum;
int scores[10][3];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("bowling.inp", "r", stdin);
    freopen("bowling.out", "w", stdout);
    cin>>t;
    for(int i=0;i<t;i++){
        int score = 0;

        for(int j=0;j<10;j++){
            cin>>firstNum;
            scores[j][0] = firstNum;
            if(firstNum<10||j==9){
                cin>>secondNum;
                scores[j][1] = secondNum;
            }
            if(j==9&&firstNum+secondNum>9){
                cin>>thirdNum;
                scores[j][2] = thirdNum;
            }
        }
        for(int j=0;j<9;j++){
            //strike
            if(scores[j][0]==10){
                //다음 풀 프레임 합산
                score+= scores[j+1][0]+scores[j+1][1];
                // 다음 프레임도 스트라이크고 마지막 프레임이 아니라면
                if(scores[j+1][0]==10&&j+1!=9){
                    score+=scores[j+2][0];
                }
            }
            // spair
            else if(scores[j][0]+scores[j][1]==10){
                score+=scores[j+1][0];
            }
            // 기본점수 개산
            score+=scores[j][0]+scores[j][1];
            scores[j][0] = scores[j][1] = scores[j][2] = 0;
        }
        score += scores[9][0]+scores[9][1]+scores[9][2];
        scores[9][0] = scores[9][1] = scores[9][2] = 0;
        cout<<score<<"\n";
    }
    return 0;
}
