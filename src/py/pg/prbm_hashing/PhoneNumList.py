## Hashing 사용한 방법 O(n) 시간복잡도로 가능
def solution(phone_book):
    hash_map = {}
    
    for phone_number in phone_book:
        hash_map[phone_number] = 1 # O(n) n은 1~1,000,000
        
    for phone_number in phone_book:
        temp = ""
        for number in phone_number: # O(m) m은 1~20
            temp += number
            if temp in hash_map and temp != phone_number: # O(1)
                return False
            
    return True

## Hashing없이 O(n**2)으로 푸는 방법
def solution2(phone_book):
    for i in range(0, len(phone_book)-1) :
        for j in range(i+1, len(phone_book)) : ## 여기서 index 1이 아니라 i+1인거 주의
            minLen = min(len(phone_book[i]), len(phone_book[j]))
            if phone_book[i][0:minLen] == phone_book[j][0:minLen] :
                return False
    return True

## 정렬하는 방법
## 접두사, 접미사 -> 정렬 순서대로
def solution2(phoneBook):
    phoneBook = sorted(phoneBook)
    for i in range(0, len(phoneBook)-1) :
        if phoneBook[i+1].startswith(phoneBook[i]):
            return False
    return True