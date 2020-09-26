package jv.pg.kakao2020;

import java.util.*;

public class ParenthesisConversion {

	public static void main(String[] args) {

	}
	
    public String solution(String p) {
        // 1단계
        if(p.equals("")) return p;
        
        // 2단계
        String u = "";
        String v = "";
        for(int i=2; i<=p.length(); i+=2) {
            u = p.substring(0, i);
            if(isBalanced(u)) {
                // if(i==p.length()) break;
                v = p.substring(i);
                break;
            }
        }
        // 3단계
        if(isCorrect(u)) {
            return u+solution(v);
            
        // 4단계 when u is not correct
        } else { 
            return "("+solution(v)+")"+reverse(u);
        }
        
    }
    
    public boolean isBalanced(String p) {
        int open = 0;
        int close = 0;
        
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i)=='(') {
                ++open;
            } else { // p.charAt(i)==')'
                ++close;
            }
        }
        
        if(open==close) {
        	return true;
        } else {
        	return false;        
        }
    }
    
    public boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            
            if(c=='(') {
                stack.push(c);
            } else if(c==')') {                
                if(stack.size()==0) {
                    return false;
                }
                
                if (stack.peek()=='(') { // && c==')'                    
                    stack.pop();
                } else { // c==')' && stack.peek()!='(' // pop했기 때문에 '('여야만 함  '))'가 연속으로 스택에 들어갈 수 없음
                    return false;
                }
            }
        }
        return true;        
    }
    
    public String reverse(String p) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<p.length()-1; i++) {
            char c = p.charAt(i);            
            if(c=='(') {
            	sb.append(')');
            } else {
            	sb.append('(');            
            }
        }
        
        return sb.toString();
        
    }

}
