def solution(priorities, location):
    cnt = 0

    while True :
        prime_idx = 0
        prime_val = priorities[0]
        for idx, val in enumerate(priorities) :
            if val > prime_val :
                prime_idx = idx
                prime_val = val
        
        for i in range(prime_idx) :
            priorities.append(priorities[0])
            del priorities[0]
        del priorities[0]
        cnt += 1

        if location==prime_idx :
            break
        
        location -= prime_idx+1
        if location<0 :
            location = len(priorities)+location+1

    return cnt