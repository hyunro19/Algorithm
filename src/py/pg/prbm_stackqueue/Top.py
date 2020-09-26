def solution(heights):
    stack = []
    answer = []
    for i, h in enumerate(heights) :
        print(stack)
        print(answer)

        if len(stack)==0 :
            stack.append(i)
            answer.append(0)
        elif heights[stack[len(stack)-1]]>h :
            answer.append(stack[len(stack)-1]+1)            
            stack.append(i)            
        elif heights[stack[len(stack)-1]]<=h :
            while len(stack)>0 and heights[stack[len(stack)-1]]<=h :
                stack.pop()
            if len(stack)==0 :
                answer.append(0)
            else :
                answer.append(stack[len(stack)-1]+1)            
            stack.append(i)    
    return answer

## 훨씬 깔끔한 풀이
def solution2(heights):
    stack = []
    answer = []

    for i, h in enumerate(heights) :
        receiver_idx = 0

        while len(stack)>0 :
            top_idx = stack[len(stack)-1]

            if heights[top_idx] > h :
                receiver_idx = top_idx+1
                break
            stack.pop()

        stack.append(i)
        answer.append(receiver_idx)
        
    return answer