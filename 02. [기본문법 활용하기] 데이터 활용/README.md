# 02. [기본문법 활용하기] 데이터 활용

## 1. 변수 기본

- 변수는 데이터가 저장된 메모리의 일정 공간을 의미함

- 변수 선언이란 메모리에 데이터를 저장하기 위해 일정한 공간을 확보하고 지정하는 것을 의미함

- 변수 선언 문법

  ```
  데이터 타입 변수이름;
  ```

- 변수의 이름은 영문자로 시작하며 한단어로 표현함

- 선언된 변수에 값을 저장하는 문법 

  ```
  변수 이름 = 값;
  ```

- 자바의 변수의 타입

  - 기본 데이터 타입
  - 참조 데이터 타입



## 2. 데이터 종류

- 논리 타입
  - true와 false 값만 가질 수 있으며 boolean(1byte)으로 선언함
- 문자 타입
  - 문자 한글자를 저장할 수 있으며, char(2byte)으로 선언함
- 정수 타입
  - byte(1byte), short(2byte), int(4byte), long(8byte)으로 선언함
- 실수 타입
  - float(4byte), double(8byte)
  -  으로 선언함
- 8가지 기본 타입을 제외한 타입은 모두 참조타입으로서 메모리 주소 값이 저장됨



## 3. 데이터 연산

|    구분     |                     연산자                      |
| :---------: | :---------------------------------------------: |
| 산술 연산자 |                  +  -  *  /  %                  |
| 증감 연산자 |                     ++  --                      |
| 비교 연산자 |              <  >  >=  <=  ==  !=               |
| 부호 연산자 |                      -  +                       |
| 대입 연산자 |               +=  -=  *=  /=  %=                |
| 조건 연산자 |                 &  &&  \|  \|\|                 |
| 비트 연산자 |            &  \|  ^  ~  <<  >>  >>>             |
| 삼항 연산자 | 변수 = 조건 ? (참 일 시) 값1 : (거짓 일 시) 값2 |



## 4. 데이터 타입 변환

- 데이터 타입을 직접 변경하는 문법

  ```
  (변경한 타입)변수 또는 값
  ```

  