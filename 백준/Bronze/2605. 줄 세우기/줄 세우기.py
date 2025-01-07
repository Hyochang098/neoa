N = int(input())
num = list(map(int,input().split()))

clas = [i for i in range(1,N+1)]
line=[]
for k in range(N):
    line.insert(len(line)-num[k], clas[k]) 

print(*line)