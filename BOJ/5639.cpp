// 5639 - 이진 탐색 트리

#include<iostream>
#include<stdlib.h>
#include<stdio.h>
using namespace std;
int a;
struct treenode {
	int v;
	treenode *left, *right;
};
treenode* root = NULL;
void ins(int value) {
	treenode *tmp, *newnode = (treenode*)malloc(sizeof(treenode));
	newnode->v = value;
	newnode->left = NULL;
	newnode->right = NULL;
	if (root == NULL)
		root = newnode;
	else {
		tmp = root;
		while (1) {
			if ((tmp->v) < value) {
				if (tmp->right == NULL) {
					tmp->right = newnode;
					break;
				}
				tmp = tmp->right;
			}
			else if ((tmp->v) > value) {
				if (tmp->left == NULL) {
					tmp->left = newnode;
					break;
				}
				tmp = tmp->left;
			}
		}

	}
}
void postor(treenode *k) {
	if (k == NULL)
		return;
	postor(k->left);
	postor(k->right);
	cout << k->v << "\n";
}
int main() {
	while (scanf_s("%d",&a)!=EOF)
		ins(a);
	postor(root);
}