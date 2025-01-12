n = int(input())
a=[1]
point= 1
while a[-1]<n:
    a.append(a[-1]+6*point)
    point+=1
print(point)
