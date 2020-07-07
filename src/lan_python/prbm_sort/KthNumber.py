def solution(array, commands):
    answer = []
    for cmd in commands:
        # 몇 번째부터 몇 번째까지 자르는지 index 중요!
        
        ## 방법1 sorted()메소드는 정렬된 리스트를 반환
        temp = sorted(array[cmd[0]-1:cmd[1]])
        
        ## 방법2 sort()메소드는 리턴값이 Null
        # temp = array[cmd[0]-1:cmd[1]]
        # temp.sort()
        
        answer.append(temp[cmd[2]-1])    
    return answer