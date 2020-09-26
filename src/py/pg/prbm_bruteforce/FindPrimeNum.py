from itertools import permutations
from itertools import combinations
import math

def solution(numbers):
    cards = list(numbers)
    comb = set()
    for i in range(1, len(numbers)+1):
        for j in list(combinations(cards,i)):
            comb.add(j)
            
    perm = list()            
    for k in comb:
        for l in list(permutations(k, len(k))):
            perm.append(l)
    
    sets = set()
    for tup in perm:
        num = ''
        for t in tup:
            num+=str(t)
        a = int(num)
        if isPrime(a):
            sets.add(a)

    return len(sets)

def isPrime(number):
    if number < 2:
        return False
    
    sqrt = round(math.sqrt(number))
    for i in range(2, sqrt+1):
        if number%i == 0: return False
    return True
    
    