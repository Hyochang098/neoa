N,X = map(int,input().split())
case = list(map(int,input().split()))
ans =[]
for i in range(len(case)):
    if case[i] < X:
        ans.append(case[i])
print(*ans)