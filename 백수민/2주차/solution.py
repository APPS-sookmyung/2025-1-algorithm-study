# 프로그래머스 > 코딩테스트 > 스택/큐 > 기능개발

from math import ceil

def solution(ps, ss):
    days = [ ceil((100 - p) / s)for p, s in zip(ps, ss) ]
    
    push = []
    ans = []
    for i in days:
        if (not push) or (push[0] >= i):
            push.append(i)
        else:
            ans.append(len(push))
            push = [i]
            
    ans.append(len(push))
        
    return ans
