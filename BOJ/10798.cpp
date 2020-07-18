//백준 - 10798 - 세로읽기
//rere
#include<iostream>
char a[5][16],i,j,k;
int main(){
    for(;i<5;i++) {
        j=0;
        std::cin>>a[i];
        while(a[i][j++]!='\0'){}
    }
    for(i=0;i<15;i++)
        for(j=0;j<5;j++)
            if(a[j][i]!='\0')
                std::cout<<a[j][i];
}