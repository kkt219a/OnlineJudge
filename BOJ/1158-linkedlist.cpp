//백준 - 조세퍼스 - 1158 - Linked List Pract

#include<iostream>
#include<stdlib.h>
using namespace std;

struct person{
	int num;
	person *next;
};

struct HList{
	person *tail,*bef,*cur;
};

void HInit(HList *hs){
	hs->tail=NULL;
}
void HInsert(HList *hs,int num){
	person* newp=(person*)malloc(sizeof(person));
	newp->num=num;
	if(hs->tail==NULL){
		hs->tail=newp;
		newp->next=newp;
	}
	else{
		newp->next=hs->tail->next;
		hs->tail->next=newp;
	}
}
int HFirst(HList *hs,int num){
	hs->bef=hs->tail;
	hs->cur=hs->tail;
	return (hs->cur->num);
}
int HNext(HList *hs,int num){
	hs->bef=hs->cur;
	hs->cur=hs->cur->next;
	return (hs->cur->num);
}

int HDelete(HList *hs){
	person *dp=hs->cur;
	int data=dp->num;
	hs->bef->next=hs->cur->next;
	hs->cur=hs->bef;
	if(hs->cur==hs->tail)
		hs->tail=hs->bef;
	free(dp);
	return data;
}

int main(){
	int n,m,k=0;
	HList a;
	cin>>n>>m; //(n,m)은 n명이서 m번째 제거

	HInit(&a);
	cout<<"<";
	for(int i=n;i>0;i--){
		HInsert(&a,i);
	}
	HFirst(&a,k);

	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++)
			HNext(&a,k);
		cout<<HDelete(&a);
		if(i!=n-1)
			cout<<", ";
	}
	
	cout<<">";
	
}
