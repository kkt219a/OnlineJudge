// samsung codeground - 2 - 프로그래밍 경진대회 
// 무조건 다시 

#include<iostream>
#include<algorithm>
using namespace std;

int Answer;

int main(){
	setbuf(stdout, NULL);
	int T,*score,N,max; //Test case, score(<=2,000,000), number(1<=N<=300,000)
	
	cin>>T;
	
	for(int i=0;i<T;i++){
		Answer=0;
		cin>>N;
		score=(int*)malloc(sizeof(int)*N);
		
		for(int j=0;j<N;j++)
			cin>>score[j];
		
		sort(score,score+N);
		max=0;
		
		for(int j=0;j<N;j++){ // l번째 인덱스의 친구가 승리할수있는지 판단하기 위해서
			if(max<(score[j]+(N-j)))
				max=score[j]+(N-j);
		}
		for(int j=0;j<N;j++){
			if(score[j]+N>=max)
				Answer++;
		}
		cout << "Case #" << i+1 << endl;
		cout << Answer << endl;
		free(score);
	}
	return 0;
}