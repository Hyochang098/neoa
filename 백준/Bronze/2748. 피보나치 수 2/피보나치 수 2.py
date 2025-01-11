N = int(input())
case =[]
a = 0
b = 1
case.append(a)
case.append(b)
for i in range(N):
  c = case[i]+case[i+1]
  case.append(c)
print(case[N])