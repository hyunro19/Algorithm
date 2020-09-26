def solution(number, k):
    stack = [number[0]]
    for num in number[1:]:
        while len(stack) > 0 and stack[-1] < num and k > 0:
            k -= 1
            stack.pop()
        stack.append(num)
    if k != 0:
        stack = stack[:-k]
    return ''.join(stack)


## test case 10 시간초과 발생 
def solution2(number, k):
    result = []
    numLen = len(number)
    startIndex = 0

    for i in range(k, numLen):
        tempMaxIndex = startIndex
        for j in range(startIndex, i+1):
            if number[j]>number[tempMaxIndex]:
                tempMaxIndex = j
        result.append(number[tempMaxIndex])
        startIndex = tempMaxIndex+1
    
    return ''.join(result)

a = solution2('999', 2)
print(a)