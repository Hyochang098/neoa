N =int(input())
A = list(map(str,input()))
ans = 0
for i in range(len(A)):
    ans +=int(A[i])
print(ans)