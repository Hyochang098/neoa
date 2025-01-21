T = int(input()) 
for _ in range(T):
    a, b = map(int, input().split())
    a %= 10  
    if a == 0:
        print(10)  
    elif a == 1 or a == 5 or a == 6:
        print(a)  
    else:
        if a == 2:
            cycle = [2, 4, 8, 6]
        elif a == 3:
            cycle = [3, 9, 7, 1]
        elif a == 4:
            cycle = [4, 6]
        elif a == 7:
            cycle = [7, 9, 3, 1]
        elif a == 8:
            cycle = [8, 4, 2, 6]
        elif a == 9:
            cycle = [9, 1]

        print(cycle[(b - 1) % len(cycle)])
