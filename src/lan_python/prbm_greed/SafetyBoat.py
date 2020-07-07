def solution(people, limit):
    firstIndex = 0
    lastIndex = len(people)-1
    count = 0    
    people.sort()
    
    while firstIndex <= lastIndex :
        if people[firstIndex]+people[lastIndex] <= limit :
            firstIndex += 1
            lastIndex -= 1 #
        else :
            lastIndex -= 1 # 이 부분 중복이라 한 블럭 바깥으로 빼내도 된다
        count += 1

    return count