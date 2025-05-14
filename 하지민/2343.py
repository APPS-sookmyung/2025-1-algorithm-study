N, M = map(int, input().split()) 
lectures = list(map(int, input().split()))

low = max(lectures)
high = sum(lectures)
result = high

while low <= high:
    mid = (low + high) // 2
    count = 1
    total = 0

    for lecture in lectures:
        if total + lecture > mid:
            count += 1
            total = lecture
        else:
            total += lecture

    if count <= M:
        result = mid  
        high = mid - 1
    else:
        low = mid + 1  

print(result)