
# daangn-item-crawler

``daangn-item-crawler``는 당근마켓 특정 상품의 가격비교를 하는 배치프로그램이다. 구조화된 작업을 위해 ``Spring-Batch`` framework를 활용하고 있고, 
html 파싱은 ``Jsoup``라이브러리를 활용하여 작업하고 있다.

## Table of Contents
- [Technologies](#technologies)
- [Acknowledgements](#acknowledgements)
- [Author](#authors)

## Technologies

- Java Version 8
- Spring-Batch Version 4.3.3
- Jsoup Version 1.13.1
- MySql DB

## DataBase

## Acknowledgements

 - [Spring Batch Official Documents](https://docs.spring.io/spring-batch/docs/4.3.x/reference/html/)
 - [Spring Batch Official API-Doc](https://docs.spring.io/spring-batch/docs/4.3.x/api/index.html)
 - [Selenium Official Documents](https://www.selenium.dev/documentation/)

## API

- `/api` : 공통 API URI
  - `item` : 상품명을 넣으면 상품 리스트 불러오기
  - `location` : 거래 지역을 넣으면 거래지역의 상품 리스트 불러오기

## Authors

Created by [@jungsolsol(https://github.com/jungsolsol) 
