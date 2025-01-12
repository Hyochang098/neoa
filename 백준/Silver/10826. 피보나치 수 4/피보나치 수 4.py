n = int(input())
a=0
b=1
if n ==0:
    print(0)
else:
    for _ in range(n-1):
       a,b = b,a+b
    
    print(b)
