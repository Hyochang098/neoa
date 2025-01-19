n=int(input())
case=list(map(int,input().split()))
sum_case=[]
for i in range(len(case)):
    if i==0:
        sum_case.append(case[i])
    else:
        sum_case.append(sum_case[i-1]+case[i])

m=int(input())
for _ in range(m):
    a,b=map(int,input().split())
    if a==1:
        print(sum_case[b-1])
    elif a==b:
        print(case[b-1])
    else:
        print(sum_case[b-1]-sum_case[a-2])