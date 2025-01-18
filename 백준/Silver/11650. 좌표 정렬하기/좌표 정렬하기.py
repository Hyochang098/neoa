n=int(input())
case=[]
for _ in range(n):
    a = list(map(int, input().split()))
    case.append(a)

sorted_case = sorted(case, key=lambda x:( x[0],x[1]))
for raw in sorted_case:
    print(*raw)