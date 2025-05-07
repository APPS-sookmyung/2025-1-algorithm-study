import sys
sys.setrecursionlimit(200000)

def dfs(node):
    for next_node in graph[node]:
        if parent[next_node] == 0:  # 방문하지 않은 노드인 경우
            parent[next_node] = node  # 부모 설정
            dfs(next_node)  # 재귀적으로 자식 노드 탐색

# 입력 받기
N = int(input())  # 노드의 개수
graph = [[] for _ in range(N + 1)]  # 인접 리스트
parent = [0] * (N + 1)  # 부모를 저장할 배열

for _ in range(N - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

parent[1] = -1  # 루트는 부모가 없으므로 -1로 설정
dfs(1)  # DFS를 이용하여 부모 노드를 찾음

# 2번 노드부터 N번 노드까지 부모 출력
for i in range(2, N + 1):
    print(parent[i])
