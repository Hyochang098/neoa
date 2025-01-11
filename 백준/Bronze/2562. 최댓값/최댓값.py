case=[]
for _ in range(1,10):
    a=int(input())
    case.append(a)
print(max(case))
print((case.index(max(case)))+1)