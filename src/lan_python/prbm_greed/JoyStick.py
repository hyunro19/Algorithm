import queue

## 문제가 이상한 부분이 있다.
## 41번 라인에서 <=하면 오류, <하면 통과한다. 왜지?

def solution(name):
    answer = 0
    deq = queue.deque()
    
    for idx, val in enumerate(name):
        if val != 'A' :
            answer += countUpDown(val)
            deq.append(idx)
    
    # 모두 A인 경우
    if len(deq)==0:
        return answer
    
    # 시작자리 처리
    if deq[0] == 0:
        deq.popleft()

    crntIdx = 0
    
    # 여기서 선언 안해줘도 돌아간다. if블록 안에서 변수선언을 해줬는데...
    # dstnLeft = 0
    # dstnRight = 0
    
    while len(deq) > 0 :
        if crntIdx < deq[0] :
            dstnLeft = len(name)-deq[len(deq)-1]+crntIdx
            dstnRight = deq[0]-crntIdx
        else :
            dstnLeft = crntIdx-deq[len(deq)-1]
            dstnRight = len(name)-crntIdx+deq[0]
            
        # 조건부 표현식 사용시
        # dstnLeft = len(name)-deq[len(deq)-1]+crntIdx if crntIdx < deq[0] else crntIdx-deq[len(deq)-1]
        # dstnRight = deq[0]-crntIdx if crntIdx < deq[0] else len(name)-crntIdx+deq[0]
        
        if dstnLeft < dstnRight :            
            crntIdx = deq.pop()
            answer += dstnLeft            
        else :
            crntIdx = deq.popleft()
            answer += dstnRight
        
    return answer

def countUpDown(char):    
    # ord('a') = 65, ord('z') = 90
    down = 91-ord(char)
    up = ord(char)-65
    return min(down, up)



