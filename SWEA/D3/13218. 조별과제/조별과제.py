T= int(input())
for test_case in range(1,T+1):
    note = ['#',str(test_case)]
    N =int(input())
    print(''.join(note),N//3)