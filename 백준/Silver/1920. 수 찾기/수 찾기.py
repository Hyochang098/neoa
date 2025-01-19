n=int(input())
case=set(map(int,input().split()))

m=int(input())
check=list(map(int,input().split()))

ans=[0]*m
for i in range(m):
    if check[i] in case:
        ans[i]=1
    else:
        continue
for row in ans:
    print(row)