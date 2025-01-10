A=list(map(str, input()))
B=[]
for i in range(len(A)):
    B.append(int(A[i]))

if sum(B)<10:
  if sum(B)%3 == 0:
    print(0)
    print("YES")
  else:
    print(0)
    print("NO")
else:
    C= sum(B)  
    count=1
    while True:
        if C>=10:
            C = sum(int(j)for j in str(C))
            count +=1
        else:
            break
  
    if C %3 == 0:
        print(count)
        print("YES")
    else:
        print(count)
        print("NO")