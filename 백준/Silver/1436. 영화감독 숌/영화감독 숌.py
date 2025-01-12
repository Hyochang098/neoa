N=int(input())
a=[]
b=666
check =0
while check < 10001:
    if "666" in str(b):
        a.append(b)
        check +=1
    b += 1
print(a[N-1])