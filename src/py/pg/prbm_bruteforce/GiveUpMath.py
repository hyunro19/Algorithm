def solution(answers):
    answer = [0, 0, 0]
    
    student1 = [1,2,3,4,5]    
    student2 = [2,1,2,3,2,4,2,5]
    student3 = [3,3,1,1,2,2,4,4,5,5]
    len1 = len(student1)
    len2 = len(student2)
    len3 = len(student3)
    cnt1 = 0
    cnt2 = 0
    cnt3 = 0
    
    for idx, val in enumerate(answers) :
        if student1[idx%len1] == val :
            cnt1 += 1
        if student2[idx%len2] == val :
            cnt2 += 1
        if student3[idx%len3] == val :
            cnt3 += 1
            
    if(cnt1>cnt2 and cnt1>cnt3) : answer = [1]
    elif(cnt2>cnt1 and cnt2>cnt3) : answer = [2]
    elif(cnt3>cnt1 and cnt3>cnt2) : answer = [3]
    elif(cnt1==cnt2 and cnt2>cnt3) : answer = [1,2]
    elif(cnt1==cnt3 and cnt3>cnt2) : answer = [1,3]
    elif(cnt2==cnt3 and cnt3>cnt1) : answer = [2,3]
    elif(cnt1==cnt2 and cnt2==cnt3) : answer = [1,2,3]
    
    return answer