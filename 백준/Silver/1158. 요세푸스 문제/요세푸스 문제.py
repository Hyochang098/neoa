from collections import deque

n, k = map(int, input().split())
case = deque(range(1, n+1))
yose = []

while case:
    case.rotate(-(k-1))
    yose.append(case.popleft())

print("<" + ", ".join(map(str, yose)) + ">")
