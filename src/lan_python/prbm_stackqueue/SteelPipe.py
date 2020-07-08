def solution(arrangement):
    stack = 0
    answer = 0
    last = True # True == '(' , False = ')'
    for idx, val in enumerate(arrangement) :
        
        if val == '(' :
            last = True
            stack += 1
        else : # val == ')'
            ## answer에 더해주는 행위는 )가 나올 때만 해주는게 포인트
            if last == True :
                answer += stack-1 # stack-1값만큼 더해주어야 한다.
            else :
                answer += 1
            last = False
            stack -= 1

    return answer