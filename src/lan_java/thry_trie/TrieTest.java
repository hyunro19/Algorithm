package lan_java.thry_trie;

/* Class Trie Test */
public class TrieTest {
    public static void main(String[] args) {
        
        //�ڷᱸ���� ������ ������
        String data[] = new String[]{"abcd","abcf", "bcd","a", "bcdefg", "defg", "aac", "baz", "foo", "foobar","�ڹ�"};
        
        Trie matcher = new Trie();

        for (int i = 0; i < data.length; i++) {
             //�迭�� �ִ� �����͸� trie �ڷᱸ���� ����
            matcher.insert(data[i]);
        }

        //trie�� �ִ� ������ �ֿܼ� ����.
        matcher.printWord(); 
        
        
        System.out.println("=======����========");
        System.out.println("[abcd,abc,a] ����");
        matcher.remove("abcd");
        matcher.remove("abc");
        matcher.remove("a");
        
        System.out.println("===================");
        
        matcher.printWord();
        
        System.out.println("=======�˻�========");
        
        for (int i = 0; i < data.length; i++) {
            System.out.println("\tsearch test["+data[i]+"]:"+matcher.search(data[i]));
        }
        
    }//main

}//class
