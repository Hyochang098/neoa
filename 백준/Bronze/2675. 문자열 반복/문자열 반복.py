T=int(input())
for _ in range(T):
    a, b = map(str,input().split())
    a = int(a)
    b = [str(i) for i in b]
    c=[]
    for i in range(len(b)):
        c.append(b[i]*a)
    print(''.join(c))