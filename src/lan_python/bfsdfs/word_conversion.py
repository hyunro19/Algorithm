def conversible(bgn, tgt):
    flag = True
    for l, r in zip(bgn, tgt) :
        if not ord(l)-ord(r) : # 같을 때
            continue
        else : # 다를 때
            if flag == False :
                return False # 두 글자 이상 차이남
            flag = False
    return True

def dfs(before, target, words, used, depth):
    # 문제 조건에서 단어수가 max 50이므로
    # 임의의 숫자인 99 사용
    min_cnt = 99
    
    # Case 1&2 중에서 1을 먼저 하는 게 포인트

    # Case1 : 마지막까지 가기 전에 조건을 만족하는 경우    
    if before == target:
        return depth

    # Case2 : 마지막 까지 다 가는 경우
    if depth==len(words):
        return 99
    
    for i, w in enumerate(words):
        if used[i]:
            continue
        if conversible(before, w): 
            used[i] = True
            min_cnt = min(min_cnt, dfs(w, target, words, used, depth+1))
            used[i] = False

    return min_cnt

def solution(begin, target, words):
    used = [False]*len(words)
    answer = dfs(begin, target, words, used, 0)
    return answer if answer!= 99 else 0

print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))