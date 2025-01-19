while True:
    a, b = map(int, input().split())
    if a== 0 and b ==0:
        break
    else:
        if a//b == a/b:
            print("multiple")
        elif b//a == b/a:
            print("factor")
        else:
            print("neither")