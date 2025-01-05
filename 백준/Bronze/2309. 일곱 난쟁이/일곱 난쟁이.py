dwarfs = [int(input()) for _ in range(9)]

for i in range(9):
    for j in range(i + 1, 9):
        if sum(dwarfs) - (dwarfs[i] + dwarfs[j]) == 100:
            result = [dwarfs[k] for k in range(9) if k != i and k != j]
            result.sort()
            print(*result)
            break
    else:
        continue
    break
