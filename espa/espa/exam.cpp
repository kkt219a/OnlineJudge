//
//  exam.cpp
//  espa
//
//  Created by 김규태 on 2021/09/17.
//

#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#pragma warning(disable:4996)
using namespace std;
int t,n;
string good, p, q[100];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("exam.inp", "r", stdin);
    freopen("exam.out", "w", stdout);
    cin>>t;
    for(int i=1;i<=t;i++){
        cin>> good>>p>>n;
        cout<<"Test Case: #"<<i<<"\n";
        for(int j=0;j<n;j++){
            cin>>q[j];
            int discard = 0; // 0: * 안만남, 1: * 만나서 뒤에서부터 시작, 2: * 다시 만나고 끝
            bool avail = false;
            int k=0, kp=0, tmpk = 0;
            for(;;k = (discard==0)?k+1:k-1, kp = (discard==0)?kp+1:kp-1){
//                cout<<k<<" "<<kp<<"\n";
                if(!(k<q[j].length()&&kp>-1)){
                    avail = true;
                    break;
                }
                if(p.at(kp)=='*'){
                    if(discard==1){
//                        cout<<k<<" "<<tmpk<<"x\n";
                        int cnt = 0;
                        for(int ll=tmpk;ll<=k;ll++){
                            if (good.find(q[j].at(ll)) != string::npos){
                                cnt++;
                            }
                        }
//                        cout<< cnt<<"zz\n";
                        if(cnt==k-tmpk+1){
                            if(k>=tmpk){
                                avail=false;
                            }else{
                                avail = true;
                            }
                        }else{
                            avail = true;
                        }
                        break;
                    }else{
                        discard = 1;
                        tmpk = k;
                        k = q[j].size();
                        kp = p.size();
                    }
                }
                else if(p.at(kp)=='?'){
                    bool fail = true;
                    for(int l=0;l<good.length();l++){
                        if(good.at(l)==q[j].at(k)){
                            fail = false;
                            break;
                        }
                    }
                    if(fail){
                        break;
                    }
                }
                else{
                    if(q[j].at(k)!=p.at(kp)){
                        break;
                    }
                }
            }
            cout<< (avail ? "Yes" : "No") <<"\n";
        }
        for(int j=0;j<n;q[j++]="");
    }
    return 0;
}
