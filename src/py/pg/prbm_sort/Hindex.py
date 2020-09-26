def solution(citations):
    citations.sort(reverse=True)
    h = 0
    while citations[h]>=h+1 :
        h += 1
        
        # 1번 인용된 논문이 1개 있는 경우에 대한 예외처리
        # array index out of bounds exception
        if h>=len(citations) :
            return h
    return h

## for문 사용하는게 예외처리도 필요 없고 더 깔끔.
## 단 off-one에 대한 주의 필요
def solution2(citations):
    citations.sort()    
    h = 0
    for i in range(len(citations)-1, -1, -1):
        if citations[i] >= h+1 :
            h += 1
    return h