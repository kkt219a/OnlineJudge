//
//  paper.cpp
//  espa
//
//  Created by 김규태 on 2021/09/15.
// 19:36~20:10
//

#include <iostream>
#include<string>
#include<algorithm>
#include<vector>
#include<utility>
#include<map>
#pragma warning(disable:4996)
using namespace std;
int n;
int startX,startY,endX,endY;
vector<pair<pair<int,int>,pair<int,int>>> dot;
vector<pair<pair<int,int>,pair<int,int>>> duplicateDot;
vector<pair<pair<int,int>,pair<int,int>>> duplicateDot2;
map<pair<pair<int,int>,pair<int,int>>,int> duplicateDot3;
int notVisual, littleVisual, visual;

pair<pair<int,int>,pair<int,int>> duplicated(pair<int,int> startA, pair<int,int> endA,
                pair<int,int> compareStart, pair<int,int> compareEnd
){
    int dStartX, dStartY, dEndX, dEndY;
    dStartX = max(startA.first, compareStart.first);
    dStartY = max(startA.second, compareStart.second);
    dEndX = min(endA.first, compareEnd.first);
    dEndY = min(endA.second, compareEnd.second);
    
    if(
       (startA.first<=dStartX && dStartX <= endA.first)
       &&(startA.second<=dStartY && dStartY <= endA.second)
       &&(startA.first<=dEndX && dEndX <= endA.first)
       &&(startA.second<=dEndY && dEndY <= endA.second)
       &&(dStartX<dEndX&&dStartY<dEndY)
    ){
        return make_pair(make_pair(dStartX,dStartY),make_pair(dEndX,dEndY));
    }
    return make_pair(make_pair(-1,-1),make_pair(-1,-1));
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("1.inp", "r", stdin);
    freopen("paper.out", "w", stdout);
    cin>> n;
    for(int i=0;i<n;i++){
        cin>>startX>>startY>>endX>>endY;
        dot.push_back(make_pair(make_pair(startX,startY),make_pair(startX+endX,startY+endY)));
    }
    for(int i=0;i<n;i++){
        duplicateDot.clear();
        duplicateDot2.clear();
        double size = ((double)(dot.at(i).second.first-dot.at(i).first.first)*(double)(dot.at(i).second.second-dot.at(i).first.second));
        double copySize = size;
        // i번째 사각형과 중복되는 모든 것을 빼고, 벡터에 넣는다.
        for(int j=i+1;j<n;j++){
            pair<pair<int,int>,pair<int,int>> duplicate = duplicated(dot.at(i).first, dot.at(i).second, dot.at(j).first, dot.at(j).second);
            if(duplicate.first.first!=-1){
                size-= ((double)(duplicate.second.first-duplicate.first.first)*(double)(duplicate.second.second-duplicate.first.second));
                duplicateDot.push_back(duplicate);
            }
        }
        // 중복되는 것들끼리
        for(int k=0;k<duplicateDot.size();k++){
            duplicateDot3.clear();
            for(int l=k+1;l<duplicateDot.size();l++){
                pair<pair<int,int>,pair<int,int>> duplicate = duplicated(duplicateDot.at(k).first, duplicateDot.at(k).second, duplicateDot.at(l).first, duplicateDot.at(l).second);
                if(duplicate.first.first!=-1){
                    size+= ((double)(duplicate.second.first-duplicate.first.first)*(double)(duplicate.second.second-duplicate.first.second));
                    map<pair<pair<int,int>,pair<int,int>>,int>::iterator it = duplicateDot3.find(duplicate);
                    if (it != duplicateDot3.end()){
                        it->second += 1;
                    }else{
                        duplicateDot3.insert({duplicate,1});
                    }
                }
            }
            for(auto iter = duplicateDot3.begin();iter!=duplicateDot3.end();iter++){
                size-=iter->second;
                cout<<iter->second<<"xxxx\n";
            }
        }

        cout<<size<<" "<<copySize<<"\n\n";
        if(size==0){
            notVisual++;
        }else if(size==copySize){
            visual++;
        }else{
            littleVisual++;
        }
    }
    cout<<notVisual<<" "<<littleVisual<<" "<<visual<<"\n";
    return 0;
}
