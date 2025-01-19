from collections import deque
n=int(input())
case=deque(i for i in range(1,n+1))

cost=0
while True:
    if len(case) == 1:
        break
    else:
        cost +=1
        if cost % 2 ==1:
            case.popleft()
        elif cost % 2 == 0:
            case.rotate(-1)
print(case.popleft())