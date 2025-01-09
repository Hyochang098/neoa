T = int(input())
for test in range(T):
    L, R = map(int, input().split())
    if R - L + 1 <= L:
        print("yes")
    else:
        print("no")
