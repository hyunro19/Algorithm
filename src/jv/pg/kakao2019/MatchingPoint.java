package jv.pg.kakao2019;

import java.util.*;

public class MatchingPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "blind";
		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		System.out.println(solution(word, pages));
	}
	
    public static int solution(String word, String[] pages) {
        Map<String, Page> map = new HashMap<>(); // 사이트 -> [기본, 외부링크수, 피링크수, 매칭점수]
        
        for(String page : pages) {
            // 1. 현재사이트 주소 얻기
        	int a = page.indexOf("<meta property=\"og:url\" content=\"")+"<meta property=\"og:url\" content=\"".length();
            int b = page.indexOf("\"/>\n</head>");
            String thisUrl = page.substring(a, b);
            if(map.get(thisUrl)== null) map.put(thisUrl, new Page());
            
            // 2. 단어개수(기본점수) 
            // 2-1. body와 /body 사이 추출
            int c = page.indexOf("<body>\n")+"<body>\n".length();
            int d = page.indexOf("</body>");
            String body = page.substring(c, d);
            
            int h = 0;
            int e = body.indexOf("<a href=\"")+"<a href=\"".length();
            StringBuilder text = new StringBuilder();
            int numOfLinkTo = 0;
            System.out.println(body.contains("</a>"));
            while(e!=-1) {
            	text.append(body.substring(h, e)); // 링크 이전부분까지 text만 추출
            	
            	int f = body.indexOf("</a>", e);
            	String linkTo = body.substring(e, f);            	
                numOfLinkTo++;                                               
                h = f+"\"></a>".length();
                e = body.indexOf("<a href=\"", h)+"<a href=\"".length();                                                   
                
                if(map.get(linkTo)==null) map.put(linkTo, new Page());
                Page p = map.get(linkTo);
                p.inward.add(thisUrl);
            }
            text.append(body.substring(h)); // 마지막 링크 뒤쪽 텍스트도 추가                                
             // 이제 온전한 텍스트를 얻었다.
            
            // 모두 소문자로 변환
            String lowerText = text.toString().toLowerCase();
            String lowerWord = word.toLowerCase();
            int freq = 0;
            int g = lowerText.indexOf(lowerWord);            
             while(g!=-1) {
            	 
                 if(g!=0) {
                	 char m = lowerText.charAt(g-1);
                	 if(m<97 || m>122) {
                		 g = lowerText.indexOf(lowerWord, g+lowerText.length());
                		 continue;
                	 }                	 
                 }
                 if(g+lowerWord.length()<lowerText.length()) {
                     char n = lowerText.charAt(g+lowerWord.length()); // word 바로 다음 character                	 
                	 if(n<97 || n>122) {
                		 g = lowerText.indexOf(lowerWord, g+lowerText.length());
                		 continue;
                	 }     
                 }
                 ++freq;
                 g = lowerText.indexOf(lowerWord, g+lowerText.length());
                     //둘다 아니면 ++기본점수 추가
             } 
             Page p = map.get(thisUrl);
             p.basic = freq;
             p.outward = numOfLinkTo;
             // 이렇게 url, 기본점수, 외부링크수를 얻었다.
        }

        for(Page v : map.values()) {
        	ArrayList<String> inward = v.inward;
        	for(String s : inward) {
        		Page vv = map.get(s);
        		v.match=(double)v.basic/(double)v.outward;
        	}
        }
        // 4. 링크점수 & 매칭점수 구하기
        // 마지막 map 순회를 다시 한 번 해야될 듯
        
        int x = 0;
        Page[] pp = new Page[map.values().size()];
        for(Page v : map.values()) {
            pp[x++]=v;
        }
        Arrays.sort(pp, new Comparator<Page>() {

			@Override
			public int compare(Page o1, Page o2) {
				if(o1.match==o2.match) {
					return o1.idx-o2.idx;
				} else {
					return (int)(o2.match-o1.match);
				}				
			}
        	
        });
        
        
        return pp[0].idx;
    }
}

class Page {
	int idx = 999;
	int basic;
	int outward;
	ArrayList<String> inward;
	double match;
	Page() {
		this.inward = new ArrayList<>();
	}
	
}
