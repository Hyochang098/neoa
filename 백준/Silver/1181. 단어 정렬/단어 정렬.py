a = int(input())
b = []

for i in range(a):
    c = input()
    b.append(c)

b_clear = sorted(set(b), key=lambda x: (len(x), x))

for word in b_clear:
    print(word)
