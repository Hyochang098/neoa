mario = []
for _ in range(10):
    a = int(input())
    mario.append(a)

mush = []
for i in range(10):
    if i == 0:
        mush.append(mario[i])
    else:
        mush.append(mush[i - 1] + mario[i])
found = False
catch = 0  
for i in range(len(mush)):
    if mush[i] > 100:
        catch = i - 1
        found = True
        break

if not found:
    catch = len(mush) - 1

if catch == -1:
    print(mush[0])
elif catch == len(mush) - 1:
    print(mush[-1])
else:
    left = mush[catch]
    right = mush[catch + 1]

    left_diff = abs(100 - left)
    right_diff = abs(100 - right)

    if left_diff < right_diff:
        print(left)
    elif right_diff < left_diff:
        print(right)
    else:
        print(max(left, right))
