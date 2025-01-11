A =int(input())
B =int(input())
C =int(input())
D = str(A*B*C)
case =[int(d) for d in D]
checklist=[0 for _ in range(10)]
for i in range(len(case)):
  if case[i]==0:
    checklist[0] +=1
  elif case[i]==1:
    checklist[1] +=1
  elif case[i]==2:
    checklist[2] +=1
  elif case[i]==3:
    checklist[3] +=1
  elif case[i]==4:
    checklist[4] +=1
  elif case[i]==5:
    checklist[5] +=1
  elif case[i]==6:
    checklist[6] +=1
  elif case[i]==7:
    checklist[7] +=1
  elif case[i]==8:
    checklist[8] +=1
  elif case[i]==9:
    checklist[9] +=1
for a in checklist:
    print(a)