n,k = map(int,input().split())
temper=list(map(int,input().split()))
total_temper = 0
for j in range(k):
    total_temper += temper[j]
max_temper = total_temper
for i in range(1,n-k+1):
    total_temper = total_temper - temper[i-1] +temper[i+k-1]
    max_temper = max(max_temper, total_temper)

print(max_temper)
