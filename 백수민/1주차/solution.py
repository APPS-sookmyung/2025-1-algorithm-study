# 프로그래머스 > 코딩테스트 연습 > 스택/큐 > 같은 숫자는 싫어

def solution(arr):
    answer = []

    for i in arr:
        if answer[-1:] == [i]:
            continue
        answer.append(i)
    
    return answer

