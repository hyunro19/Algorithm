def solution(participant, completion):
    ptcpt = {}
    for p in participant :
        ptcpt[p] = ptcpt.get(p, 0)+1

    for c in completion :
        # 이 문제 조건에서는 이 부분에서 NullPointerException이 발생할 수 없음        
        if ptcpt.get(c) == 1 :
            del ptcpt[c]
        else :
            ptcpt[c] = ptcpt.get(c)-1

    kys = list(ptcpt.keys())
    return kys[0]

# a.get(x, '디폴트 값') ## java의 gerOrDefault()
ptcpt = {}
ptcpt['a'] = 'b'

# print(ptcpt['h']) ## 오류 발생 KeyError: 'h' // java의 nullPointerException
# print(ptcpt['h']=='a')
print(None == 'a') # False
print(ptcpt) # {'a': 'b'}
print(hash('Alice')) # -88372724881992084
print(hash('Alice')) # -88372724881992084
print(hash('James')) # 3428203630085322012
print(type(hash('Alice'))) # <class 'int'>

## 신박한 풀이
def solution2(participant, completion):
    answer = ''
    temp = 0
    dic = {}
    for part in participant:
        dic[hash(part)] = part
        temp += int(hash(part))
    for com in completion:
        temp -= hash(com)
    answer = dic[temp]

    return answer

## collections.Counter객체를 이용한 짧은 풀이
import collections

def solution3(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]
