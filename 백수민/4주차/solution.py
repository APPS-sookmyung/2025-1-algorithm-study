'''
프로그래머스 > 코딩테스트 연습 > 힙(Heap) > 더 맵
1. 주어진 음식들의 스코빌 지수를 K 이상으로 만들기 위해, 스코빌 지수가 가장 낮은 두 개의 음식을 섞어 새로운 음식을 만듦.
2. 섞은 음식의 스코빌 지수는 "가장 맵지 않은 음식 + (두 번째로 맵지 않은 음식 * 2)"로 계산.
3. 모든 음식의 스코빌 지수가 K 이상이 되기 위해 섞은 횟수를 구하고 반환, 불가능하면 -1을 반환.
'''


from heapq import heapify, heappop, heappush


def solution(scoville, k):
    # 스코빌 리스트를 힙으로 변환 
    heapify(scoville)

    mix_count = 0
    while (scoville[0] < k):
        
        # 음식의 스코빌 지수가 k 이상이 될 수 없을 때  
        if (len(scoville) < 2):
            return -1

        # 가장 낮은 스코빌 지수 가져오기 
        first = heappop(scoville)
        second = heappop(scoville)

        # 새로운 음식의 스코빌 지수를 구한 후 힙에 추가 
        mixed = first + (second * 2)
        heappush(scoville, mixed)

        # 섞은 횟수 업데이트 
        mix_count += 1

    return mix_count

