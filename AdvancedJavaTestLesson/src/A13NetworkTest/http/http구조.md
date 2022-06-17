# Http 구조

<hr>

## Requests Message

<hr>

### [Request Line] <br>

```
(POST_/index.html_HTTP/1.1)(메소드방식, 경로, 버전)
get 방식 : url , a태그
	- 바디가 없음 , 정보를 더 보내고 싶으면 queryString을 사용 (?=)
	- 값을 가져올 때 사용
post 방식 : form태그
	- 데이터를 보낼 때
```

<hr>

### [Header]<br>

```
~~~~~ : ~~~~~
~~~~~ : ~~~~~
~~~~~ : ~~~~~
~~~~~ : ~~~~~
~~~~~ : ~~~~~
```

<hr>

### [Empty Line]

<hr>

### [Body]

<hr>
<br>

## Responses Message

<hr>

### [Status Line]<br>

```
(HTTP/1.1_200_OK)(버전, 상태, 메세지)
```
<hr>

### [Header]<br>

```
~~~~~ : ~~~~~
~~~~~ : ~~~~~
~~~~~ : ~~~~~
(content type : text/html)
```

<hr>

### [Empty Line]

<hr>

### [Body]

<hr>
