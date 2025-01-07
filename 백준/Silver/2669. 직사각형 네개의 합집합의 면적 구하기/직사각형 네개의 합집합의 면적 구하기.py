size = set()
for i in range(4):
    square = list(map(int,input().split()))
    for j in range(square[0],square[2]):
        for k in range(square[1],square[3]):
            size.add((j,k))

print(len(size))