a, b= map(int,input().split())
case=set()
sample =[]
for i in range(a,b+1):
    if i == 1:
        continue
    if i == 2:
      case.add(i)
      continue
    if i % 2 == 1:
        a = int(i ** 0.5)+1
        for j in range(2,a+1):
            if i % j == 0:
                break
        else:
            case.add(i)
for k in case:
    print(k)