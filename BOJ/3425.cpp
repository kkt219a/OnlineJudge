//3425 - 고스택 - 빡구현ㅡㅡ 스택 큐등등 여러가지

#include<iostream>
#include<stack>
#include<queue>
#include<algorithm>
#include<math.h>
#include<string>
#define si 1000000000
using namespace std;
long long inv, tmp1,tmp2,tmp3; // 함수들에서 사용할 변수, 곱셈에서 21억을 초과할 수 있으니 long long
stack<long long> nows; // 새명령어 받아들일때 같이 초기화
queue<string> commandbar; // 새 명령어 받아들일때 초기화 필요
bool e;
//num x: nows.push(x); --> 0<=<=1억 인지 체크 필요
void INV() { //부호 변경, 스택이 비었는지 체크
	inv = nows.top();
	nows.pop();
	nows.push(-inv);
}
//DUP는 바로 nows.push(nows.top());
void SWP(){ // 바꾸기, 스택크기가 2이상인지 확인
	tmp1 = nows.top();
	nows.pop();
	tmp2 = nows.top();
	nows.pop();
	nows.push(tmp1);
	nows.push(tmp2);
}

void ADD() { // 스택크기 2이상인지 확인, 연산결과가 절대값 1억 넘으면 탈락
	tmp1 = nows.top();
	nows.pop();
	tmp2 = nows.top();
	nows.pop();
	if (abs(tmp2 + tmp1) > 1000000000) //이따가 에러처리 , 1억 이상인가 초과인가..?
		e = 1;
	else nows.push(tmp2 + tmp1);
}
void SUB() { // 스택크기 2이상인지 확인, 연산결과가 절대값 1억 넘으면 탈락
	tmp1 = nows.top();
	nows.pop();
	tmp2 = nows.top();
	nows.pop();
	if (abs(tmp2 - tmp1) > 1000000000) //이따가 에러처리 , 1억 이상인가 초과인가..?
		e = 1;
	else nows.push(tmp2 - tmp1);
}
void MUL() { // 스택크기 2이상인지 확인, 연산결과가 절대값 1억 넘으면 탈락
	tmp1 = nows.top();
	nows.pop();
	tmp2 = nows.top();
	nows.pop();
	if (abs(tmp2*tmp1) > 1000000000) //곱이 1억 넘어가도 에러처리, 1억 이상인가 초과인가..?
		e = 1;
	else nows.push(tmp2*tmp1);
}

void DIV() {  // 스택크기 2이상인지 확인, 연산결과가 절대값 1억 넘으면 탈락
	tmp1 = nows.top();
	nows.pop();
	tmp2 = nows.top();
	nows.pop();
	if (tmp1 == 0) // 0일때 에러처리
		e = 1;
	else {
		tmp3 = abs(tmp2) / abs(tmp1);
		if (tmp3 > 1000000000) //나누기가 1억 넘어가도 에러처리, 10억 이상인가 초과인가..?
			e = 1;
		else {
			if ((tmp1 < 0 && tmp2>0) || (tmp1 > 0 && tmp2 < 0)) // 음수면 음수 몫 넣기
				nows.push(-tmp3);
			else nows.push(tmp3); // 둘다 음수거나 둘다 양수면 양수 몫
		}
	}
}

void MOD() { // 스택크기 2이상인지 확인, 연산결과가 절대값 1억 넘으면 탈락
	tmp1 = nows.top();
	nows.pop();
	tmp2 = nows.top();
	nows.pop();
	if (tmp1 == 0) // 0일때 에러처리
		e = 1;
	else {
		tmp3 = abs(tmp2) % abs(tmp1);
		if (tmp3 > 1000000000) //나누기가 1억 넘어가도 에러처리, 1억 이상인가 초과인가..?
			e = 1;
		else {
			if (tmp2 < 0) // 당하는애가 음수면 나머지도 음수
				nows.push(-tmp3);
			else nows.push(tmp3);
		}
	}
}
string input,ttmp; // num 10억+\0까지 = 0~14공간 차지 그래서 안전하게 16받기
long long n, i, number, x, y, value, gop;
int jj;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (getline(cin, input);input.compare("QUIT")!=0; getline(cin, input)) { //QUIT나오면 다 끝
		if (input.compare("END") == 0) { // 숫자 입력받을 준비가 됐다면?!
			for (e=0, cin >> n, i = 0; i < n; i++,e=0) { //n개의 숫자에 대해서 매번 처리를 하자!
				cin >> number;
				nows.push(number);
				for (x=0,y=commandbar.size();x<y;x++) { // 처음 명령어로 돌아올 때까지
					ttmp = commandbar.front(); //명령어
					if (!e) { //에러가 없다면
						if (ttmp[0] == 'N') { //무조건 num x
							for (value = 0, gop = 1, jj = ttmp.length() - 1; jj > 3; value += (ttmp[jj--] - 48)*gop, gop *= 10);
							if (value > 1000000000)
								e = 1;
							else nows.push(value);
						}
						else if (ttmp.compare("POP")==0) { // 빈거 아니면 삭제
							if (!nows.empty())
								nows.pop();
							else e = 1;
						}
						else if (ttmp.compare("INV") == 0) { // 빈거 아니면 부호 변경
							if (!nows.empty())
								INV();
							else e = 1;
						}
						else if (ttmp.compare("DUP") == 0) { // 그냥 바로 위에 한개 더 놓기
							if (!nows.empty())
								nows.push(nows.top());
							else e = 1;
						}
						else if (ttmp.compare("SWP") == 0) { // 스택 2개있으면 교체
							if (nows.size() > 1)
								SWP();
							else e = 1;
						}
						else if (ttmp.compare("ADD") == 0) { // 스택 2개 미만이면 에러
							if (nows.size() > 1)
								ADD();
							else e = 1;
						}
						else if (ttmp.compare("SUB") == 0) { // 스택 2개 미만이면 에러
							if (nows.size() > 1)
								SUB();
							else e = 1;
						}
						else if (ttmp.compare("MUL") == 0) { // 스택 2개미만 에러
							if (nows.size() > 1)
								MUL();
							else e = 1;
						}
						else if (ttmp.compare("DIV") == 0) { // 스택 2개미만 에러
							if (nows.size() > 1)
								DIV();
							else e = 1;
						}
						else if (ttmp.compare("MOD") == 0) { // 스택 2개미만 에러
							if (nows.size() > 1)
								MOD();
							else e = 1;
						}

					}
					//cout << e << "\n";
					commandbar.pop(); // 에러있든없든 순서는 원상복구 시켜줘야지
					commandbar.push(ttmp); // 뒤로 원상복구 시켜주기
				}
				if (nows.size() != 1 || e == 1) cout << "ERROR\n"; 
				else cout << nows.top() << "\n";
				for (; !nows.empty(); nows.pop()); // 현재 숫자 다썻으면 다음 숫자 위해 비워주기 
			}
			for (; !commandbar.empty(); commandbar.pop()); // 숫자 케이스 다썻으면 명령어칸 비어주기
			cout << "\n";
		}
		else // end 아니면 무조건 다 넣어
			commandbar.push(input);
	}
}