def round2(x):
    y = x*100-int(x)*100
    if y>=50:
        z = int(x)+1
    else:
        z = int(x)
    return z
    
a= int(input())
b=[]
for i in range(a):
    c = int(input())
    b.append(c)

d = sorted(b)

e = round2(a*0.15)
f= []
for j in range(e,a-e):
    f.append(d[j])

if  len(f) == 0:
    print(0)
else:
    print(round2(sum(f)/len(f)))
