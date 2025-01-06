n, k = map(int,input().split())
school =[]
for _ in range(n):
    student = list(map(int,input().split()))
    school.append(student)
  
boy_1=[]
boy_2=[]
boy_3=[]
boy_4=[]
boy_5=[]
boy_6=[]
girl_1 = []
girl_2 = []
girl_3 = []
girl_4 = []
girl_5 = []
girl_6 = []
for i in range(n):
  if school[i][0] == 0:
    
    if school[i][1]==1:
        girl_1.append(school[i])
    elif school[i][1]==2:
        girl_2.append(school[i])
    elif school[i][1]==3:
        girl_3.append(school[i])
    elif school[i][1]==4:
        girl_4.append(school[i])
    elif school[i][1]==5:
        girl_5.append(school[i])
    elif school[i][1]==6:
        girl_6.append(school[i])
  else:
    if school[i][1] == 1:
        boy_1.append(school[i])
    elif school[i][1] == 2:
        boy_2.append(school[i])
    elif school[i][1] == 3:
        boy_3.append(school[i])
    elif school[i][1] == 4:
        boy_4.append(school[i])
    elif school[i][1] == 5:
        boy_5.append(school[i])
    elif school[i][1] == 6:
        boy_6.append(school[i])

def up(a):
  if a - int(a) >0:
   return int(a)+1
  return int(a)
    
room_boy_1 = up(len(boy_1)/k)
room_boy_2 = up(len(boy_2)/k)
room_boy_3 = up(len(boy_3)/k)
room_boy_4 = up(len(boy_4)/k)
room_boy_5 = up(len(boy_5)/k)
room_boy_6 = up(len(boy_6)/k)
room_girl_1 = up(len(girl_1)/k)
room_girl_2 = up(len(girl_2)/k)
room_girl_3 = up(len(girl_3)/k)
room_girl_4 = up(len(girl_4)/k)
room_girl_5 = up(len(girl_5)/k)
room_girl_6 = up(len(girl_6)/k)
print(room_boy_1+room_boy_2+room_boy_3+room_boy_4+room_boy_5+room_boy_6+
     room_girl_1+room_girl_2+room_girl_3+room_girl_4+room_girl_5+room_girl_6)
