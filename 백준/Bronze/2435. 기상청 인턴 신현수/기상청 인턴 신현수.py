n,k = map(int,input().split())
temper=list(map(int,input().split()))
sum_temper=[0]*(n-k+1)
for i in range(len(sum_temper)):
    for j in range(k):
        sum_temper[i] += temper[i+j]

print(max(sum_temper))
