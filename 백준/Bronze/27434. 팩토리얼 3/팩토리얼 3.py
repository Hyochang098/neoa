def fac(a):
    b=1
    for i in range(1,a+1):
       b*=i
    return b
a=int(input())
print(fac(a))
