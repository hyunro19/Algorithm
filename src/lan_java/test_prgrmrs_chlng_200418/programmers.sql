-- Programmers Oracle
-- table��, column�� ��ҹ��� ���� X
-- field���� ������

-- WHERE NOT �̶� ���� ���� 2���� �� ���� ������ ��
WHERE NOT INTAKE_CONDITION='Aged'
ORDER BY NAME ASC, DATETIME DESC

-- WHERE NOT
WHERE PRICE <>100;
WHERE NOT PRICE =100;

-- ���� n�� ���� ������ �� ROWNUM ���
SELECT NAME 
FROM (SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME DESC)
WHERE ROWNUM < 2;

-- Max
SELECT Max(DATETIME) AS �ð� FROM ANIMAL_INS;

-- Count
SELECT Count(*) FROM TABLE;

-- Sum
SELECT Sum(TEMP)
FROM (SELECT '1' AS TEMP FROM ANIMAL_INS)

-- �ߺ� ���� DISTINCT // IS NOT NULL
SELECT Count(*) as COUNT 
FROM (SELECT DISTINCT NAME FROM ANIMAL_INS WHERE NAME IS NOT NULL)


--GROUP BY �� WEHRE���� ���� 2���� ����
--�����̿� ���� ����ϱ�?
--GROUP���� �Ϳ� ���ؼ� Į���� �����ش�.
SELECT * FROM (
SELECT ANIMAL_TYPE, count(*) count FROM ANIMAL_INS WHERE ANIMAL_TYPE = 'Cat' OR ANIMAL_TYPE = 'Dog'  GROUP BY ANIMAL_TYPE
    ) ORDER BY ANIMAL_TYPE;
    
SELECT [GROUP BY ���� ������ �÷�1] [GROUP BY���� ������ ��] 
FROM [���̺� ��] 
GROUP BY [ �׷����� ���� �÷� �� ]
--https://jink1982.tistory.com/63
    
--Having ���� Group by�� ����� �� �� where �� ó�� Ư�� ������ �߰�
SELECT CLASS, SUM(SCORE) 
FROM TBL_REPORT_CARD 
GROUP BY CLASS
HAVING SUM(SCORE) > 150 ;

SELECT * FROM (
SELECT NAME, COUNT(*) COUNT FROM ANIMAL_INS WHERE NAME IS NOT NULL GROUP BY NAME HAVING COUNT(*) >= 2
    ) ORDER BY NAME;
    
    
--DATE �ð� ����
    
SELECT * FROM (
	SELECT TO_NUMBER(HOUR) HOUR, COUNT(HOUR) COUNT FROM	(
			SELECT TO_CHAR(DATETIME,'HH24') HOUR FROM ANIMAL_OUTS 
		   			) GROUP BY HOUR
    					) WHERE HOUR >=9 AND HOUR <=19 ORDER BY HOUR


-- 24�ð�
--http://www.gurubee.net/article/61629
SELECT TO_CHAR ( LEVEL ) lv FROM DUAL CONNECT BY LEVEL <= 24

-- JOIN, OUTERJOIN (����Ŭ vs ANSI)
-- �׸��� 24�ð� ���� ���Ҷ� 0�� ���ڵ嵵 �ִ� �������

--���1 // NVL ��� (Į��, null�϶� ��ü�� ��) // ��ü���� '��'�� �´�
 SELECT b.HOUR HOUR, nvl(a.COUNT, 0) COUNT 
 FROM
 (SELECT TO_NUMBER(TO_CHAR(DATETIME, 'HH24')) HOUR, COUNT(TO_CHAR(DATETIME, 'HH24')) COUNT FROM ANIMAL_OUTS GROUP BY TO_CHAR(DATETIME, 'HH24') ) a, 
 (SELECT TO_NUMBER(LEVEL)-1 HOUR FROM DUAL CONNECT BY LEVEL <= 24) b 
 WHERE b.HOUR = a.HOUR(+) 
 ORDER BY HOUR

--���2 ANSI
SELECT hour, nvl(count, 0) count FROM (
SELECT b.HOUR HOUR, a.COUNT COUNT
FROM 				 (SELECT TO_NUMBER(TO_CHAR(DATETIME, 'HH24')) HOUR, COUNT(TO_CHAR(DATETIME, 'HH24')) COUNT 
						FROM ANIMAL_OUTS GROUP BY TO_CHAR(DATETIME, 'HH24') ORDER BY HOUR ) a
RIGHT OUTER JOIN 		(SELECT TO_NUMBER(LEVEL)-1 HOUR FROM DUAL CONNECT BY LEVEL <= 24) b
ON      a.HOUR = b.HOUR
ORDER BY hour
)

-- +���̴� ���⿡ ���� (�� "ª�Ƽ�" Ȯ���ؾ� �ϴ� �ʿ� +�� ���̴°Ŵ�.) // ���ʿ� ���̴°� �ƴ�.


--IN
SELECT *
  FROM TABLE 
 WHERE COLUMN IN ('A' , 'B')

--IN (Ǯ��� ���)
SELECT *
  FROM TABLE 
 WHERE COLUMN  = 'A' 
    OR COLUMN = 'B'

-- NOT IN (Ǯ��� ���)
SELECT *
  FROM TABLE 
 WHERE COLUMN NOT IN ('A' , 'B')
 
SELECT *
  FROM TABLE 
 WHERE COLUMN  <> 'A' 
   AND COLUMN <> 'B'

-- NOT IN ���� ��
SELECT ANIMAL_ID, NAME FROM ANIMAL_OUTS WHERE ANIMAL_ID 
NOT IN 		(SELECT ANIMAL_ID FROM ANIMAL_INS) 
ORDER BY ANIMAL_ID


-- JOIN (+) ���� �򰥷��� ���� ��̴� ����
SELECT * FROM (
SELECT ANIMAL_INS.NAME, ANIMAL_INS.DATETIME
FROM ANIMAL_INS, ANIMAL_OUTS
WHERE ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID(+)
AND ANIMAL_INS.ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM ANIMAL_OUTS)
ORDER BY ANIMAL_INS.DATETIME
) WHERE ROWNUM <=3;

-- LIKE ���� ���� �˻�
--��ó: https://devjhs.tistory.com/81 [Ű����� �Ϸ�]
WHERE �÷� [NOT] LIKE (%) �˻��� �� ( _ , % ) 

SELECT * 
FROM TEST_TABLE_ONE
WHERE TEL LIKE '010%'


SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.ANIMAL_TYPE, ANIMAL_OUTS.NAME
FROM ANIMAL_INS, ANIMAL_OUTS
WHERE ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
AND ANIMAL_INS.SEX_UPON_INTAKE LIKE 'Intact%'
AND ANIMAL_OUTS.SEX_UPON_OUTCOME NOT LIKE 'Intact%'
ORDER BY ANIMAL_OUTS.ANIMAL_ID

-- WHERE�ȿ� AND���ǰ� OR������ ȥ�յǾ� ���� �� // LIKE ���
SELECT * FROM (
	SELECT ANIMAL_ID, NAME
	FROM ANIMAL_INS
	WHERE ANIMAL_TYPE = 'Dog' )
WHERE NAME LIKE '%el%'
OR NAME LIKE 'El%'
ORDER BY NAME


-- SELECT������ �÷��� ���뿡 ���� �ٸ������� ����ϱ�
-- https://breadshuttle.tistory.com/entry/Oracle-SELECT%EB%AC%B8%EC%97%90%EC%84%9C-%EC%BB%AC%EB%9F%BC%EC%9D%98-%EB%82%B4%EC%9A%A9%EC%97%90-%EB%94%B0%EB%9D%BC-%EB%8B%A4%EB%A5%B8%EA%B0%92%EC%9C%BC%EB%A1%9C-%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0

-- DECODE : https://gent.tistory.com/227

-- Decode�� like�˻��� �� �� ���� �Ϸ��� case������
--��ó: https://ghstylus.tistory.com/17 [������ �غ���]
������ case when raw like '%��' then ' '||'1' else '2' || �̰ɷ� ����
-- CASE�� Ǯ��
SELECT ANIMAL_ID, NAME,
    CASE
        WHEN SEX_UPON_INTAKE LIKE '%Neutered%' THEN 'O'
        WHEN SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
        ELSE 'X'
    END AS �߼�ȭ
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

-- DECODE�� Ǯ��	
SELECT ANIMAL_ID, NAME,
    DECODE(SEX_UPON_INTAKE, 'Neutered Male', 'O', 'Spayed Female', 'O', 'X') AS �߼�ȭ
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

-- ��ȣ�Ⱓ ����� ���� 2����
SELECT ANIMAL_ID, NAME FROM (
SELECT ANIMAL_INS.ANIMAL_ID ANIMAL_ID, ANIMAL_INS.NAME NAME, ANIMAL_OUTS.DATETIME-ANIMAL_INS.DATETIME STAYTIME
FROM ANIMAL_INS, ANIMAL_OUTS
WHERE ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
ORDER BY STAYTIME DESC --Alias�ε� �ش� Select���� ���� ���� ����
) WHERE ROWNUM<3

-- DATETIME ����ȯ
SELECT ANIMAL_ID, NAME, TO_CHAR(DATETIME, 'YYYY-MM-DD') ��¥
FROM ANIMAL_INS
ORDER BY ANIMAL_ID