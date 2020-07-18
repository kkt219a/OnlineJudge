// 2161 - 카드1 - 큐
#include<stdio.h>
#include<stdlib.h>

typedef struct node {
	int data;
	struct node* next;
}Node;

typedef struct queue {
	Node *front;
	Node *rear;
}Queue;

void push(Queue *pq,int data) {
	Node *newnode = (Node*)malloc(sizeof(Node));
	newnode->data = data;
	newnode->next = NULL;
	if (pq->front == NULL) {
		pq->front = newnode;
		pq->rear = newnode;
	}
	else {
		pq->rear->next = newnode;
		pq->rear = newnode;
	}
}

int pop(Queue*pq) {
	Node *del;
	int d;
	del = pq->front;
	pq->front = pq->front->next;
	d = del->data;
	free(del);
	return d;
}

int peek(Queue *pq) {
	return pq->front->data;
}

void init(Queue *pq) {
	pq->front = NULL;
	pq->rear = NULL;
}

int main() {
	int n, i, d;
	Queue q;
	init(&q);
	scanf("%d", &n);
	for (i = 1; i <= n;i++)
		push(&q,i);
	
	for (i = n; i > 1; i--) {
		d=pop(&q);
		printf("%d ", d);
		d=pop(&q);
		push(&q, d);
	}
	printf("%d", peek(&q));

}