N = int(input())
kit = list(map(int,input().split()))
t, p = map(int,input().split())
t_shirt = 0
for i in range(6):
    a = kit[i] // t
    if kit[i] % t !=0:
        a = int(a)+1
    t_shirt +=a
pen = []
pen.append(N//p)
pen.append(N%p)
print(t_shirt)
print(*pen)