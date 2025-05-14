# 프로그래머스 > 코딩테스트 연습 > 정렬 > K번째
# 주어진 배열을 i부터 j까지 자르고 정렬한 후, k번째 값 반

def solution(array, commands):
    answer = []

    for command in commands:
        i = command[0] - 1
        j = command[1]
        k = command[2] - 1
        
        answer.append(sorted(array[i:j])[k])
    
    return answer
    
    
