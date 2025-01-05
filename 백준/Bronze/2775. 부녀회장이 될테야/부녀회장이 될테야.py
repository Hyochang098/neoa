T= int(input())

for test in range(1,T+1):
    k =int(input())
    n = int(input())
    apa = []
    zero = list(x for x in range(1,n+1))
    apa.append(zero)
  
    for i in range(1,k+1):
        floor =[]
        live = 1
        floor.append(1)
        apa.append(floor)
        for j in range(1,n):
            if i == 1:
                live += zero[j]
                floor.append(live)
            else:
                live += apa[i-1][j]
                floor.append(live)
  
    print(apa[k][n-1])