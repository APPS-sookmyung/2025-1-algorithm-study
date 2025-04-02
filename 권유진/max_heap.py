import heapq
import sys

input = sys.stdin.readline

def max_heap_operations(n, operations):
    heap = []
    result = []

    for op in operations:
        if op == 0:
            if heap:
                result.append(-heapq.heappop(heap))
            else:
                result.append(0)
        else:
            heapq.heappush(heap, -op)

    return result

if __name__ == "__main__":
    N = int(input())
    operations = [int(input()) for _ in range(N)]
    results = max_heap_operations(N, operations)

    for res in results:
        print(res)
