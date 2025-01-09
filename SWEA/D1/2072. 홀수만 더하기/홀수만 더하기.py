T = int(input())
for test in range(1,T+1):
    note=['#',str(test)]
    a = list(map(int,input().split()))
    sum = 0
    for i in a:
        if i % 2 == 1:
            sum +=i
    print(''.join(note),sum)