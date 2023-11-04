# 미션 - 로또

## 로또 게임 설명

- 게임 규칙
    ```
    - 로또 번호의 숫자 범위는 1~45까지이다.
    - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
    - 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
    - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
    ```
- 로또 1장의 가격은 1,000원이고, 로또 구입 금액을 사용자가 입력하면 구입 금액에 해당하는 만큼의 로또가 자동으로 발행된다.
- 사용자가 당첨 번호와 보너스 번호를 입력한다.
- 사용자가 구매한 로또 번호와 입력한 당첨 번호를 비교하여 사용자의 당첨 내역 및 수익률이 출력되고 로또 게임이 종료된다.
- ❗예외❗ 사용자가 잘못된 값을 입력할 경우, "[ERROR]"로 시작하는 에러 메시지가 출력되고, 사용자는 그 부분부터 다시 입력한다.

## 기능 목록

- [O] 구입 금액에 해당하는 개수의 로또를 발행한다.
- [] 1 ~ 45까지의 중복되지 않는 숫자 6개를 로또 번호로 생성한다.
    - [] ❗예외❗
        - 로또 번호의 개수가 6개가 아닌 경우
        - 로또 번호에 중복된 숫자가 있는 경우
- [] 사용자가 구매한 로또 번호와 입력받은 당첨 번호 및 보너스 번호를 비교한다.
    - [] 몇개의 숫자가 서로 일치하는 지를 알 수 있다.
    - [] 일치하는 숫자의 개수를 통해 당첨 결과를 생성한다.
    - [] 당첨 결과를 통해 수익률을 계산한다.
- [] 입력을 ❗예외❗ 처리한다. (사용자가 잘못된 값을 입력할 경우)
    - `IllegalArgumentException` 발생한다.
    - "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### 입출력 기능

#### 입력

- [O] 1,000원 단위의 로또 구입 금액을 입력받는다.
    - [] ❗예외❗
        - 숫자가 아닌 문자가 포함된 경우
        - 1,000원으로 나누어 떨어지지 않는 경우
- [] 1 ~ 45까지의 중복되지 않는 숫자 6개인 당첨 번호를 입력 받는다.
    - 쉼표(,)를 기준으로 구분한다.
    - [] ❗예외❗
        - 숫자가 아닌 문자가 포함된 경우
        - 입력한 당첨 번호의 개수가 6개가 아닌 경우
        - 입력한 6개의 당첨 번호에 중복된 숫자가 있는 경우
- [] 당첨 번호와 겹치지 않는, 1 ~ 45까지의 숫자 1개인 보너스 번호를 입력받는다.
    - [] ❗예외❗
        - 숫자가 아닌 문자가 포함된 경우
        - 입력한 보너스 번호의 개수가 1개가 아닌 경우
        - 이전에 입력한 당첨 번호에 입력한 보너스 번호와 중복된 숫자가 있는 경우

#### 출력

- [] 발행한 로또 수량과 오름차순으로 정렬한 로또 번호를 출력한다.
- [] 당첨 내역을 출력한다.
- [] 수익률을 소수점 둘째 자리에서 반올림하여 출력한다.
    - ex. 100.0%, 51.5%, 1,000,000.0%
- [] ❗예외❗ 상황 시, "[ERROR]"로 시작하는 에러 문구를 출력해야 한다.
    ```
    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
    ```

#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```