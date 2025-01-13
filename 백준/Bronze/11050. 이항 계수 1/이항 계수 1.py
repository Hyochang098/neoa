n, k = map(int, input().split())
def fac(a):
    b = 1
    for i in range(a):
        b *= a-i
    return b
ans = int(fac(n)/(fac(k)*fac(n-k)))
print(ans)