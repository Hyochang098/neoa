T=int(input())
for _ in range(T):
    n = int(input())
    zero =[]
    one =[]
    for i in range(n+1):
        if i == 0:
            zero.append(1)
            one.append(0)
        elif i == 1:
            zero.append(0)
            one.append(1)
        else:
            zero.append(zero[i-2]+zero[i-1])
            one.append(one[i-2]+one[i-1])
    ans = [zero[n], one[n]]
    print(*ans)