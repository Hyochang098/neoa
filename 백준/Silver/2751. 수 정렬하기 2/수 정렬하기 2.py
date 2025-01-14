a = int(input())
b = set()
c = []
for _ in range(a):
    d = int(input())
    b.add(d)
for i in b:
    c.append(i)
c= sorted(c)
for j in c:
    print(j)