/*
//---------------------------------------------------------------------------------------------------------------------------------------------------------
//와일드카드 - 완전탐색 일반적재귀 - 알고스팟 - rere
//문자열이 길거나 *도 많으면 오래걸릴거다. 
// ex) w=******a, s=aaaaaaaaaab 가 좋은예시,  패턴의 마지막은a, 문자열의 마지막은b이니 끝까지 가야 얘네가 다른걸 알수있다.
bool match(string w, string s){
	int pos=0;
	while(pos<w.size&&pos<s.size&&(w[pos]=='?'||w[pos]==s[pos])) // w와s보다 작고,w[pos]가 ?와 s[pos]와 같은건 된다. ?는 한개아무거나 대응되니까.
		pos++; // 넘어가는건 쭉쭉넘어가자 통과했다는 뜻이니
	if(pos==w.size) // w패턴이 먼저 끝났으면
		return pos==s.size; // 두개같으면 true다, w패턴이끝났으니 애초에 *과?도 없으니 pos가 s의 size만큼 증가했어야했다.
	if(w[pos]=='*'){ //*을만난거였다면 ,.,.
		for(int skip=0;skip+pos<=s.size;++skip){ // pos이후를 확인하기 위해 
			//c.substr(a) -> c의 인덱스a부터 끝까지 반환, c.substr(a,b) -> c의 인덱스a부터 b개의 단어를 반환
			if(match(w.substr(pos+1),s.substr(pos+skip))) //w의 *이후 글자부터 끝까지와, s는 pos까지는 w와 일치해 왔으니 s도 s가 끝나기 전까지 더해주며 재확인 해주면됨
				//만약에 또 *을 만난다면 여기 들어와서 w도 다시보고 s도 다시보고 반복이겠지
				return true; // 매치가 됬다면 트루란거
		}
	}
	return false; // w와s가 맞는거 못찾았을시 , s가 먼저끝나면 당연히 남아있는 패턴w는 틀린거지만, w패턴뒤에 다 * 일수도있다. 다 * 일경우
	//2번쨰 if문에서 걸러지고, 계속해서 *로만 나눠질테니 전부 true를 반환하고 맞게된다면 끝에 true를 반환할거다. 
	// w=asdf***, s=asdf 이면, pos는 s사이즈인 4이고, w[4]는 *이되니 그렇게 된다고 생각하자 예시다.
}


//와일드카드 - 메모이제이션 일반적재귀 - 알고스팟 - rere
//위에꺼랑 차이는 중복 제거밖에없음 !! ex) w=******a, s=aaaaaaaaaab 에서 *과a를 계속 비교하는 중복같은거!!
int dp[101][101]; // 최대 100개 받으니까, dp값 -1은 계산안된거, 0은 대응x, 1은 맞아떨어진거
string W,S;
bool matchMemorized(int w, int s){ // 처음시작은 (0,0)부터? (1,1)부터?
	int &ret=dp[w][s]; // &변수는 우측변수의 또다른이름! ret이 바뀌면 이제 dp도 같이바뀐다!
	if(ret!=-1)
		return ret; // 확인된거는 다시반환
	while(s<S.size()&&w<W.size()&&(W[w]=='?'||W[w]==S[s])){ // 앞과같이 변수크기보다작고 '?' 이거나 두개가같으면 인덱스 옮겨주기
		++w;
		++s;
	}
	if(w==W.size())//W가 먼저 끝나버렸다는건 *이없었다는 뜻
		return ret=(s==S.size()); // 그럼 모두 일치해야하는거니 s인덱스와 S의 크기가 같아야한다.
	if(W[w]=='*') // 결국 녀석이 *이었다면 ..
		for(int skip=0;s+skip<=S.size();++skip) // W는 *이후니 1칸뒤, S는 계속 비교해가며 끝까지 가본다
			if(matchMemorized(w+1,s+skip)) //만약에 또 *을 만난다면 여기 들어와서 w도 다시보고 s도 다시보고 반복이겠지
				return ret=1;// 매치가 됬다면 트루란거
	return ret=0; // w와s가 맞는거 못찾았을시 , s가 먼저끝나면 당연히 남아있는 패턴w는 틀린거지만, w패턴뒤에 다 * 일수도있다. 다 * 일경우
	//2번쨰 if문에서 걸러지고, 계속해서 *로만 나눠질테니 전부 true를 반환하고 맞게된다면 끝에 true를 반환할거다. 
	// w=asdf***, s=asdf 이면, pos는 s사이즈인 4이고, w[4]는 *이되니 그렇게 된다고 생각하자 예시다. 
} // 시간복잡도 n^3

//와일드카드 - 메모이제이션+시간복잡도 감소(최종) - 알고스팟 - rere
int dp[101][101];
string W,S;
bool matchMemorized(int w, int s){ 
	int &ret=dp[w][s];
	if(ret!=-1)
		return ret;
	if(s<S.size()&&w<W.size()&&(W[w]=='?'||W[w]==S[s])){ // 변경부분 :: 
		return ret=matchMemorized(w+1,s+1); // 그냥 이런방법도 있다. 위에while문 대신해서. 시간복잡도와 상관x
	}
	if(w==W.size())
		return ret=(s==S.size());
	if(W[w]=='*') 
		//*에 아무글자도 대응 안시킬건지, 한글자를 더 대응시킬건지 
		//s<S.size() 아니고 s<=S.size() ,. 오역이고
		if(matchMemorized(w+1,s)||(s<=S.size()&&matchMemorized(w,s+1))) //* 다음 글자와 비교를할지, s가 size만큼 안커진 한해서 *과 s다음 글자를 대응 시킬건지
			return ret=1; // 여기서 for문이 사라지니까 *n번 더 계산안함
	return ret=0; 
}

//----------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
// Algospot - WildCard - Answer - rere


#include<iostream>
#include<cstring>
#include<vector>
#include<algorithm>
using namespace std;
int dp[101][101],i,j;
string W,S;
bool matchMemorized(int w, int s){ 
	int &ret=dp[w][s];
	if(ret!=-1)
		return ret;
	if(s<S.size()&&w<W.size()&&(W[w]=='?'||W[w]==S[s])){
		return ret=matchMemorized(w+1,s+1);
	}
	if(w==W.size()&&s==S.size())
		return ret=1;
	if(W[w]=='*')
		if(matchMemorized(w+1,s)||(s<=S.size()&&matchMemorized(w,s+1)))
			return ret=1;
	return ret=0; 
}

int main(){
	int t,w,n;
	cin>>t;
	for(;i<t;i++){
		vector<string> v;
		cin>>W>>n;
		for(j=0;j<n;j++){
			memset(dp,-1,sizeof(dp));
			cin>>S;
			if(matchMemorized(0,0)){
				v.push_back(S);
			}
		}
		sort(v.begin(),v.end());
		for(j=0;j<v.size();j++)
			cout<<v[j]<<"\n";
		cout<<"\n";
	}
}