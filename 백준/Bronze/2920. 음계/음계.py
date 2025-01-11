a = list(map(int,input().split()))
s0rt_a = sorted(a)
rev_a = [a for a in reversed (s0rt_a)]
if a == s0rt_a:
    print("ascending")
elif a== rev_a:
    print("descending")
else:
    print("mixed")