def solution(weight):
    answer = 0
    weight.sort()
    answer += weight[0]

    for idx in range(1, len(weight)):
        if answer+1<weight[idx]:
            break
        else:
            answer += weight[idx]

    return answer+1


# 효율성 탈락 로직
def solution2(weight):
    weight.sort()
    scalable_bf = set()
    scalable_bf.add(0)
    min = 1
    for w in weight:
        # print(w, 'bf', scalable_bf)
        scalable_af = set(n+w for n in scalable_bf)
        scalable_bf = scalable_bf|scalable_af
        for i in range(min, w):
            if i not in scalable_bf:
                return i
            min = i
        # print(w, 'af', scalable_bf)
        
    return sum(weight)+1