# MyBlog-v-2

운영 블로그 주소 : http://106.10.45.102:8080/


---------------------------------------------
# 수정해야 할 것들

1) Service-Layer에서 @Transactional 남용에 대한 고찰

2) Controller-Layer에서 @GetMapping 남용에 대한 고찰

3) Controller을 좀 더 RestFul하게 바꿀 수 있는 방법에 대한 고찰

4) Content Modify 할 때 dirty check 기능 구현

5) Content Delete 할 때 바로 지워지는것이 아니라 한번 물어보도록 하는 기능 구현

6) 지금은 게시글이 모든 회원에게 보여지도록 되어 있는데 권한에 따라 게시글을 볼 수 있는 기능 구현

-> 외부 노출은 안시키고 나만 보기위해 글을 쓰고 싶을 때도 있다.

-> 이런것 들은 페이지에서 관리자가 check박스를 통해 쉽게 바꿔줄 수 있도록 구현하면 좋을듯

7) test기반 구현 

8) naver cloud => AWS free로 이전 (이전 완료)

9) github action기능으로 deploy 자동화 하기
