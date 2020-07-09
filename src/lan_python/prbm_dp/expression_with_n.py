def solution(N, number):
    pools = {}
    for i in range(9):
        pools[i] = set()
    cnt = 2
    # pools = [set()]*9 # 0~8까지, 0은 사용x
    pools[1].add(N)
    while cnt<9 :        
        for outer in range(1, cnt):
            for upward in pools[outer]:
                for downward in pools[cnt-outer]:
                    # pools를 딕셔너리가 아니라 리스트로 두었을 때
                    # Set changed size during iteration Error가 발생한다
                    # iteration중인 set과는 다른 cnt의 set에 원소 추가임에도 발생
                    # 내부적으로 '배열'처럼 관리해서 그런 것 같다.
                    
                    pools[cnt].add(int(str(N)*cnt)) # 5를 2개 쓸 때 55도 만들 수 있음
                    pools[cnt].add(upward+downward)
                    pools[cnt].add(upward-downward)
                    pools[cnt].add(upward*downward)
                    if downward != 0:
                        pools[cnt].add(upward//downward)
        if number in pools[cnt]:
            return cnt
        cnt += 1

    return -1