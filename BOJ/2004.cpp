// 2004 - 조합 0의 개수

#include<iostream>
#include<algorithm>
long long a,b,c,d;
int h(int j,int k){
    if(j==0) return 0;
	for(d=0,c=k;j/c!=0;d+=j/c,c*=k);
	return d;
}
int main(){
	std::cin>>a>>b;
	std::cout<<std::min(h(a,5)-h(a-b,5)-h(b,5),h(a,2)-h(a-b,2)-h(b,2));
}