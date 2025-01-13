from collections import deque


N= int(input())
a=deque()

for _ in range(N):
    b=list(map(str,input().split()))
    if b[0] == "push":
        c = int(b[1])
        a.append(c)
    elif b[0] == "front":
        if len(a) == 0 :
            print(-1)
        else:
            print(a[0])
    elif b[0] == "back":
        if len(a) == 0 :
            print(-1)
        else:
            print(a[-1])
    elif b[0] == "size":
        print(len(a))
    elif b[0] == "empty":
        if len(a) !=0:
            print(0)
        else:
            print(1)
    elif b[0] =="pop":
        if len(a) ==0:
            print(-1)
        else:
            print(a.popleft())