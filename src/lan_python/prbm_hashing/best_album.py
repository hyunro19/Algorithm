# TODO
#1 장르별 총 합계를 구해서 걔네를 정렬
#2 장르-리스트로 사전을 만들고, 그 리스트를 1.play내림차순 2.idx오름차순 으로 정렬
#3 #1의 순서대로 #2의 리스트를 2개씩 앨범에 수록

from functools import cmp_to_key

def compare_genres(tpl1, tpl2):
    if tpl1[1] < tpl2[1]:
        return 1
    else:
        return -1
    
def compare_songs(tpl1, tpl2):
    if tpl1[0] == tpl2[0]:
        if tpl1[1] < tpl2[1]:
            return -1
        else:
            return 1
    elif tpl1[0] > tpl2[0]:
        return -1
    else:
        return 1

def solution(genres, plays):
    album = []
    total_count_per_genre_dic = {}
    songs_per_genre_dic = {}
    
    idx_list = [i for i in range(len(genres))] 

    for g, p, i in zip(genres, plays, idx_list):
        total_count_per_genre_dic[g] = total_count_per_genre_dic.get(g, 0)+p
        songs_per_genre_dic[g] = songs_per_genre_dic.get(g, [])
        songs_per_genre_dic[g].append((p, i))

    total_count_per_genre_list = list(total_count_per_genre_dic.items())
    sorted_total_count_per_genre_list = sorted(total_count_per_genre_list, key=cmp_to_key(compare_genres))
    # print('bf', total_count_per_genre_list)
    # print('af', sorted_total_count_per_genre_list)

    # print('bf', songs_per_genre_dic)
    for k, v in songs_per_genre_dic.items():
        songs_per_genre_dic[k] = sorted(v, key=cmp_to_key(compare_songs))
    # print('af', songs_per_genre_dic)

   
    for gnr, cnt in sorted_total_count_per_genre_list:
        songs_per_genre_list = songs_per_genre_dic[gnr]
        for idx, tpl in enumerate(songs_per_genre_list):
            if idx>1:
                continue
            album.append(tpl[1])
            
    return album

# 나는 다 튜플로 처리했는데, 클래스를 만드니까 훨씬 깔끔하다.
def solution2(genres, plays):
    answer = []
    dic = {}
    album_list = []
    for i in range(len(genres)):
        dic[genres[i]] = dic.get(genres[i], 0) + plays[i]
        album_list.append(album(genres[i], plays[i], i))

    print('bf', dic)
    dic = sorted(dic.items(), key=lambda dic:dic[1], reverse=True)
    # dic.items()를 하면 튜플이 되니깐, dic[1]은 acumulative plays가 된다
    print('af', dic)
    
    for a in album_list:
        print(a.genre, a.play, end=", ")
    print()
    album_list = sorted(album_list, reverse=True) # 장르 상관없이 '곡' 기준으로 정렬
    for a in album_list:
        print(a.genre, a.play, end=", ")
    print()

    # 여기서 시간복잡도가 조금 안좋네
    while len(dic) > 0:
        play_genre = dic.pop(0)
        print(play_genre)
        cnt = 0;
        for ab in album_list:
            if play_genre[0] == ab.genre:
                answer.append(ab.track)
                cnt += 1
            if cnt == 2:
                break

    return answer

class album:
    def __init__(self, genre, play, track):
        self.genre = genre
        self.play = play
        self.track = track

    # 이건 아이디어는 좋은데 글쎄...
    # 파이썬 내장 정렬이 '안정적'이기 때문에 노래 고유번호는 신경안써도 되서 아래와 같은 아이디어도 쓸 수는 있는데,
    # 맨 마지막에 2곡씩 선정하는 부분에서 시간복잡도가 떨어진다는 단점이 있음
    def __lt__(self, other):
        return self.play < other.play
    def __le__(self, other):
        return self.play <= other.play
    def __gt__(self, other):
        return self.play > other.play
    def __ge__(self, other):
        return self.play >= other.play
    def __eq__(self, other):
        return self.play == other.play
    def __ne__(self, other):
        return self.play != other.play