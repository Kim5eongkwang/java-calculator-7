# java-calculator-precourse

## 기능 요구 사항

### 입력

- [ ] 덧셈할 문자열을 입력

### 출력

- [x] "덧셈할 문자열을 입력해 주세요." 형태로 입력 전 문자를 출력
- [ ] "결과 : 0" 형태로 덧셈 결과를 출력

### 숫자와 문자를 구분

- [x] 입력받은 문자열에서 숫자를 추출
- [x] 커스텀 구분자를 추출
    - [x] 커스텀 구분자 입력 시 "\n"가 나오지 않을 경우 예외 처리
- [x] 입력받은 문자열에서 문자를 추출
    - [x] 추출한 문자가 구분자에 등록되어 있지 않다면 예외 처리

### 숫자와 구분자를 등록

- [x] 추출한 숫자를 숫자열에 등록
    - [x] 추출한 숫자가 숫자 형식이 아닐 경우 예외 처리
- [x] 추출한 커스텀 구분자를 구분자에 등록

### 덧셈 수행

- [ ] 추출한 숫자열의 숫자를 더함

---

### 용어집

- 문자 -> letter
- 구분자 -> separator
- 숫자 -> number
- 연산기(덧셈) -> calculator
- 결과 -> result