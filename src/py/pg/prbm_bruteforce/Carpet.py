def solution(brown, yellow):
    answer = []
    for h in range(2, brown//4+2) :
        w = brown//2-h+2
        if (h-2)*(w-2) == yellow :
            answer = [w, h]    
    return answer