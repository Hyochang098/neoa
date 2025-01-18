n, k =map(int,input().split())

pre_pascal=[1]
for i in range(2,n+1):
    cur_pascal=[1]
    for j in range(1,len(pre_pascal)):
        pascal = pre_pascal[j]+pre_pascal[j-1]
        cur_pascal.append(pascal)
    cur_pascal.append(1)

    pre_pascal = cur_pascal
print(pre_pascal[k-1])