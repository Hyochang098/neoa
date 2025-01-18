import sys
input = sys.stdin.readline
n,m = map(int, input().split())
case = list(map(int, input().split()))
total_case = []

for i in range(len(case)):
    if i == 0:
        total_case.append(case[i])
    else:
        total_case.append(case[i] + total_case[i-1])

for _ in range(m):
    a,b= map(int,input().split())
    if a == 1:
        print(total_case[b-1])
    elif a == b:
        print(case[b-1])
    else:
        print(total_case[b-1] - total_case[a-2])