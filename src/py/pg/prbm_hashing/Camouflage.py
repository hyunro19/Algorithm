def solution(clothes):
    costumes = {}
    variations = 1
    for cloth in clothes :
        costumes[cloth[1]] = costumes.get(cloth[1], 0)+1
    for count in costumes.values() :
        variations *= count+1
    return variations-1