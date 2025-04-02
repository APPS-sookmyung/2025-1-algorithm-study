/**
 * a,b 가 주어졌을 때 a의 b승의 1의 자리를 출력하는 문제. 제곱수마다 반복되는 1의 자리수를
 * 캐치하고 잘 출력하는게 관건 ( 1의 자리수의 loop 가 최대 4인 것을 이 문제를 보고 깨달았다....
 */

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class math1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T,a,b;
        int temp;
        int num, result;
        List <Integer> lastNum= new ArrayList<>(); //1의자리 계산
        T=sc.nextInt();
        for(int i=0; i<T;i++){
            a=sc.nextInt();
            b=sc.nextInt();
            lastNum.clear();
            a%=10;
            for(int j=1;j<=4;j++){
                temp=(int)Math.pow(a,j)%10;
                if(lastNum.contains(temp)){//리스트에 1의 자리 숫자가 있으면 패턴이 반복되기 시작한것
                    //더 이상 계산 할 필요 없음, 반복문 종료. 최대 반복 수가 4이므로 j가 4미만
                    break;
                }
                else lastNum.add(temp);
            }
            int objNum=b%lastNum.size()-1; //핵심
            // 주어진b에서 패턴의 길이를나누고 -1을 함으로서 위치를 찾음 .

            if(lastNum.get(objNum)==0){result=10;} //1의 자리 0일때 10으로 표시
            else result=lastNum.get(objNum);
            System.out.println(result);
        }
        sc.close();
    }
}
