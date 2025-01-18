n=int(input())
ans= n
list=[]
while ans !=0 :
    ans -= 1
    str_ans = str(ans)
    anslist = [int(i)for i in str_ans]
    if ans+sum(anslist) == n:
       list.append(ans)
if len(list)==0 :
    print(0)
else:
    print(min(list))