def solution(n, lost, reserve):
    answer = 0

    list = [1 for i in range(n)]
    for l in lost:
        list[l-1] -=1

    for r in reserve:
        list[r-1] +=1

    for idx, val in enumerate(list):
        if val == 2:
            if idx == 0:
                if list[idx+1]==0:
                    list[idx+1] +=1
                    list[idx] -=1
            elif idx == len(list)-1:
                if list[idx-1]==0:
                    list[idx-1] +=1
                    list[idx] -=1
            else:
                if list[idx-1]==0:
                    list[idx-1] +=1
                    list[idx] -=1
                elif list[idx+1]==0:
                    list[idx+1] +=1
                    list[idx] -=1

    for val in list:
        if val > 0:
            answer +=1                

    return answer