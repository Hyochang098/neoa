N = int(input())
case = list(map(int, input().split()))

def prime(a):
    if a == 1: 
        return False
    for i in range(2, int(a**0.5) + 1): 
        if a % i == 0:
            return False
    return True

checklist = [prime(num) for num in case]
ans = sum(checklist)  
print(ans)
