T = int(input())
for test in range(1,T+1):
    note=['#',str(test)]
    a = list(map(int,input().split()))
    avg = sum(a)/10
    if avg-int(avg) > 0.5 or avg-int(avg) == 0.5:
        avg = int(avg)+1
    else:
        avg = int(avg)

    print(''.join(note),avg)