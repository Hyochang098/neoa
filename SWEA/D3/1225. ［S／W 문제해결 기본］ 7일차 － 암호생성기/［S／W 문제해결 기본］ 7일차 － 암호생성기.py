from collections import deque

for _ in range(1, 11):
    note = ['#', str(input())]
    que = deque(map(int, input().split()))
    num = 1
    while True:
        a = que.popleft()
        a -= num
        if a <= 0:
            que.append(0)
            break
        else:
            que.append(a)
        num = num % 5 + 1
    ans = list(que)
    print(''.join(note),*ans)
