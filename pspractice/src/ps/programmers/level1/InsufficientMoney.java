package ps.programmers.level1;

//3분 30초
class InsufficientMoney {
    public long solution(int price, long money, int count) {
        for(int i=1;i<=count;money -= (long) (i++) *price);
        return (money<0)?Math.abs(money):0;
    }
}
