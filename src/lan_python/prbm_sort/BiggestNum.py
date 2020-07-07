from functools import cmp_to_key

def compare(x, y):
    if str(x)+str(y) > str(y)+str(x) :
        return 1
    else : 
        return -1
    # elif str(x)+str(y) < str(y)+str(x) :
    #     return -1
    # else :
    #     return 0

def solution(numbers):
    numbers.sort(key=cmp_to_key(compare), reverse=True)
    answer = ''.join([str(num) for num in numbers])
    return '0' if answer[0]=='0' else answer

# 다른 사람 풀이
# 이 사람은 numbers를 str리스트로 먼저 바꾼 뒤에 정렬시킴
# 이게 더 나은듯, int->str 연산 횟수가 더 작으니까
# comparator함수 리턴 하는 부분이 이쁨

# import functools

# def comparator(a,b):
#     t1 = a+b
#     t2 = b+a
#     return (int(t1) > int(t2)) - (int(t1) < int(t2)) #  t1이 크다면 1  // t2가 크다면 -1  //  같으면 0

# def solution(numbers):
#     n = [str(x) for x in numbers]
#     n = sorted(n, key=functools.cmp_to_key(comparator),reverse=True)
#     answer = str(int(''.join(n)))
#     return answer