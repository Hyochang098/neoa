attend=[]
for _ in range(28):
    a = int(input())
    attend.append(a)
real=[i for i in range(1,31)]
for i in range(30):
    if real[i] not in attend:
        print(real[i])