N= int(input())
a = list(map(int,input().split()))

b= max(a)
c = [d/b * 100 for d in a] 
print(sum(c)/len(c))