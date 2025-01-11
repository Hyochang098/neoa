T= int(input())
for _ in range(1,T+1):
    H, W, N =map(int,input().split())
    A=N//H
    B=N%H
    if B == 0:
        A= A-1
        B=H
    room_num = 100*B +A+1
    print(room_num)