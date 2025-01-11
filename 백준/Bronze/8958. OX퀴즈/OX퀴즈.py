T = int(input())

for _ in range(T):
    result = input() 
    score = 0  
    current_streak = 0 

    for char in result:
        if char == 'O':  
            current_streak += 1
            score += current_streak
        else:  
            current_streak = 0

    print(score)
