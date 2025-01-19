a,b =map(int,input().split())
m,k = map(int,input().split())
count = 0
for i in range(a,b+1):
    if m-k<=i<=m+k:
        count+=1
if count == 0:
    print("IMPOSSIBLE")
else:
    print(count)