def oneRound(cnd, rnd):
    s = 0
    b = 0
    for idx, val in enumerate(rnd):
        if cnd[idx] == val:
            s += 1
        elif val in cnd:
            b += 1    
    return [s, b]

def rounds(cnd, baseball):
    for bb in baseball:
        rnd = [bb[0]//100, bb[0]%100//10, bb[0]%10]
        sb = oneRound(cnd, rnd)
        if bb[1]!=sb[0] or bb[2]!=sb[1]:
            return False
    return True


def solution(baseball):
    answer = 0
    candidates = list()

    for i in range(1, 10):
        for j in range(1, 10):
            if i==j:
                continue
            for k in range(1, 10):
                if i==k or j==k:
                    continue
                candidates.append([i, j, k])
    
    for cnd in candidates:
        if rounds(cnd, baseball):
            answer += 1

    return answer