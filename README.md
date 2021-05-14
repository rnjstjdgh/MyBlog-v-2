# MyBlog-v-2

운영 블로그 주소 : http://52.79.72.3/


---------------------------------------------
# 수정해야 할 것들

## 1) Service-Layer에서 @Transactional 남용에 대한 고찰

## 2) Controller-Layer에서 @GetMapping 남용에 대한 고찰

## 3) Controller을 좀 더 RestFul하게 바꿀 수 있는 방법에 대한 고찰

## 4) Content Modify 할 때 dirty check 기능 구현

## 5) Content Delete 할 때 바로 지워지는것이 아니라 한번 물어보도록 하는 기능 구현

## 6) 지금은 게시글이 모든 회원에게 보여지도록 되어 있는데 권한에 따라 게시글을 볼 수 있는 기능 구현

-> 외부 노출은 안시키고 나만 보기위해 글을 쓰고 싶을 때도 있다.

-> 이런것 들은 페이지에서 관리자가 check박스를 통해 쉽게 바꿔줄 수 있도록 구현하면 좋을듯

## 7) test기반 구현 

## 8) naver cloud => AWS free로 이전 (이전 완료)

## 9) github action기능으로 deploy 자동화 하기

## 10) nginx 서버 도입
* ![image](https://user-images.githubusercontent.com/41561652/116195967-da428b00-a76d-11eb-8882-2af5a01433f5.png)
<details>
<summary>
   설치
</summary>


* ![image](https://user-images.githubusercontent.com/41561652/116203687-eb43ca00-a776-11eb-8343-3df4dfd967ce.png)

* 참고 링크: https://velog.io/@damiano1027/Nginx-Nginx%EC%99%80-SpringBoot-%EB%82%B4%EC%9E%A5-Tomcat-%EC%97%B0%EB%8F%99
</details>

<details>
<summary>
ssl 인증서를 발급받고 443 포트로 https를 적용
</summary>
   
* https와 ssl, handshaking, session : https://opentutorials.org/course/228/4894
</details>


<details>
<summary>
로드밸런싱을 해본다던지
</summary>
   
* ~~
</details>


<details>
<summary>
DDos공격 방어를 해본다던지
</summary>
   
* 참고 링크: https://velog.io/@damiano1027/Nginx-Nginx%EC%99%80-SpringBoot-%EB%82%B4%EC%9E%A5-Tomcat-%EC%97%B0%EB%8F%99
</details>

<details>
<summary>
gzip 압축 설정
</summary>
   
* 참고 링크: https://www.lesstif.com/system-admin/nginx-gzip-59343019.html
</details>

<details>
<summary>
cache 설정
</summary>
   
* 참고 링크: 
   * https://blog.kjslab.com/175
   * https://jojoldu.tistory.com/60
</details>
   

## 11.  모니터링 해보기  

* node exporter
* spring boot
* nginx
* 

* 공부 내용 정리: https://github.com/rnjstjdgh/MyBlog-v-2/wiki/%EB%AA%A8%EB%8B%88%ED%84%B0%EB%A7%81-%EA%B4%80%EB%A0%A8-%EA%B3%B5%EB%B6%80-%EB%82%B4%EC%9A%A9-%EC%A0%95%EB%A6%AC

## 12.  
