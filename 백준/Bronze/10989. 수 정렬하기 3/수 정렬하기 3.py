N = int(input())
case = [0] * 10001

for _ in range(N):
    a = int(input())
    case[a] += 1


for i in range(10001):
    if case[i] > 0:
        for _ in range(case[i]):
            print(i)
