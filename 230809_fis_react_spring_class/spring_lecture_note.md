<u>spring</u>

[toc]

# 배경

- browser -> server
  - ​			presentation layer -> business layer -> persistance layer -> (ORM) -> DB
- ORM : Object Relation Mapping (자바쪽 object와 relation DB를 매핑시키겠다) 
  - ex) 마이바티스, JPA
- spring 의 장점 : Inversion Of Control (IOC) 제어의 역행
  - 개발자에게 객체 생성을 맡기지 않겠다 ! 프레임워크가 하겠다 !
- servlet : 웹 컴포넌트. insert, select 등의 요청이 들어오면 각각의 servlet 이 처리.  but, 진입점을 단일화시켜야 한다고 생각. => 퍼사드 패턴 (스프링에 들어가있음)
- spring 에 `web.xml` 켜보면 `dispatcher servlet` 이 하나 등록되있음. 이놈이 세션 퍼사드. 프론트 컨트롤러가 됨. 사용자의 모든 리퀘스트를 `dispatcher servlet` 이 받아서 전달전달. 여러개의 서블릿이 아니라 하나의 서블릿으로. 
- 스프링에 있는 또다른 패턴 : 싱글턴 패턴 & 팩토리 패턴. 내부적으로 인스턴스를 한 번만 생성. 사용자 요청 -> 팩토리(spring container)에게 요청 -> 팩토리에서 해당 컨트롤러 객체 있는걸 꺼내줌.

- controller : 나에게 주어진 리퀘스트를 관리하는 역할이라 업무 로직이 들어갈 수 없다. 비즈니스 레이어와 의존관계를 가질 수 밖에 없다. persistence layer은 business layer에 의존관계. 이를 위해 spring container 에게 객체생성이 됐다는 가정하에 주입시켜 줘! 라고 하게 됨 => Dipendency Injection (DI) (의존주입)
- but, SPA 로 브라우저를 만들거기 때문에 SPA가 아닌 일반 웹페이지는 `@response body` 로 자바 객체를 떨궜다. 하지만 이젠 json으로 브라우저에 떨궈줘서 리액트에서 비동기 통신 하면 됨. 



# 개발환경 세팅

- vs code에 `spring boot extension pack`, `java extension pack` , `lombok annotation support` 설치

- ctrl + shift + p : 명령어 팔레트 - spring initializr 로 gradle 이나 maven 프로젝트 생성

- 리액트 빌드시키면 src > resources > static 에 저장됨
- resources : 외부 설정과 관련된 파일들이 저장됨
- spring boot 의 내장 컨테이너의 포트를 바꿔줄 수 있다. 
- `build.gradle` : `pom.xml` 과 같다. dependencies 설정되어있음. 변경 가능



# Spring Boot Basic

- instance 를 생성할 수 있는 annotation : 3가지

- 의존관계를 정의하는 annotation 

- configuration annotation : 환경설정 파일로 등록하겠다 ! `application.properties` 를 `DBConfiguration.java` 에서 쓸 수 있도록

  - `@PropertySource` : resources 밑의 파일들을 classpath 라는걸로 갖고옴

  - ```java
    @PropertySource("classpath:/application.properties")
    ```

  - `@Configuration` : configuration 관련된 bean 객체 생성

- `DataSource` : connection pool이 됨

```JAVA
@Bean
    //@Bean(name = "mariaFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
		factoryBean.setMapperLocations(context.getResources("classpath:/mappers/**/*Mapper.xml"));
		//factoryBean.setConfigLocation(context.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setConfiguration(mybatisConfig());
        
        
		return factoryBean.getObject();
    }
```

- `@Bean(name = "mariaFactory")` : 객체 이름을 지정해줄 수 있음
- `SqlSessionFactory` : DB와 연결하는 용도 function
- `ApplicationContext` : spring이 가지고있는 내장객체. context = container. 이땐 객체생성을 요구하는게 아니라 의존성으로 주입을 받는다. => `@Autowired`

```java
context.getBean("mariaFactory")
```

- `getBean` : 객체 이름으로 객체 가져오기
- 우리는 비동기 처리를 할 것(뷰를 전달하는게 아니라 데이터만 전달)이므로 restful controller를 만들 것.

- `mapper`  폴더 : DAO(persistence layer) 역할
- interface 내 변수 접근제어자는 public으로
- `@Mapper` : 매핑을 도와주는 객체로 쓰겠다. 



## ORM (Mapper.xml)

```xml
<!-- SQL 구문을 정의하는 영역 -->
<mapper namespace="com.spring.woori_boot.mapper.PostMapper">
    <insert id="save"
            parameterType="com.spring.woori_boot.mapper.PostRequestDTO">
        INSERT INTO BLOG_TBL(TITLE, CONTENT) VALUES (
                #{title}
            ,   #{content}
        )
    </insert>
</mapper>
```

- 마이바티스는 #{} 로 변수를 넣음
- `namespace` :  mapper.java 파일 경로
- `parameterType` : 파라미터를 어디서 가져올건지. DTO에서 가져옴

```java
@Getter
@Setter
public class PostRequestDTO {
    private String title;
    private String content;
}
```

- DTO에 정의된 private 멤버변수의 변수를 그대로 써줘야 함. #{} 내 변수들이 DTO의 변수와 바인딩 됨. `@Getter`로 바로 getTitle이 호출됨. 



## DTO

- 데이터를 전달해주는 역할. 



## Mapper.java

- 인터페이스 내 메서드 이름(save)가 곧 ORM 마이바티스의 sql문 id가 됨. parameterType 은 파라미터를 갖고올 DTO의 주소가 됨.



# 리액트-Spring Boot 붙이기

## Spring boot

- 우리가 할 건 비동기이기 때문에 데이터만 갖고오면 됨. 페이지 전환은 잘 일어나지 않음. 
- `@Controller` , `@Service` : 컨트롤러, 서비스용 어노테이션
- `@Controller` 내 `@ResponseBody` : 데이터를 json형식으로 컨버팅해줌
- but, `@RestController` 로 해주면 `@ResponseBody` 필요 없음 - ajax 통신만 하는 컨트롤러다!

```JAVA
@RequestMapping(value="/index")
public List<PostResponseVO> blogs() {
        System.out.println(">>>> ctrl blogs ");
        return null;
    }
```

- 리액트로 index가 path로 들어왔을 때 `blogs()` 함수가 호출된다.
- 리액트-스프링부트가 통신할 때 크로스사이트도메인 위반하게 됨. 리액트는 3000번 포트, 스프링은 8800번 포트라 서버가 다르기 때문. 하지만 요즘 세상엔 openAPI로 많이 갔다와서 한 서버에서 갖다 쓰는 일이 많지 않음. 죄다 크로스사이트 위반됨. => `@CrossOrigin` 넣으면 해결됨

- 리액트 + 스프링부트는 자바객체가 다 json 으로 변환되어 내려옴 (`@ResponseBody`)
- json -> 자바객체 변환시엔 `@RequestBody` 가 명시되있어야 함 (post 방식일때만)

```java
@RequestMapping(value="/save")
    @CrossOrigin
    public String blogSave(@RequestBody PostRequestDTO params){
        System.out.println(">>>> ctrl blogs save ");
        service.blogSaveService(params);
        return "OK";
    }
```



## React

1. fetch 로 서버와 통신

```react
const [postObjs, setPostObjs] = useState([]);

useEffect(() => {
        fetch('http://localhost:8800/index') // url 준다.
        .then(response => response.json()) // 서버로부터 데이터 받아온다. (=success callback)
        .then(response => { // handler
            console.log(response);
            setPostObjs(response);
        });
    }, []);
```

- 서버와 통신하는것과 프론트엔드에서 라우팅하는것은 다른 개념이다. 지금 우린 데이터만 받아온다. 트랜지션은 무조건 리액트에서만 발생되고 서버는 통신만 한다. 

2. axios

```REACT
npm install axios
```

**주의할점**

- react는 기본적으로 비동기 통신이기 때문에 사용자 컴포넌트 하나하나를 렌더링할때도 서버를 갔다오는 비동기와 순서가 무작위로 되게 된다. 때문에 방어로직을 항상 추가하는게 좋다.

```REACT
return (
        <Wrapper>
            { !postObj.id && <h1>데이터 조회 중 </h1> }
            { postObj.id  && 
            <Container>
                <Button
                    title="뒤로 가기"
                    onClick={() => {
                        navigate("/");
                    }}
                />
                <PostContainer>
                    <TitleText>{postObj.title}</TitleText>
                    <ContentText>{postObj.content}</ContentText>
                </PostContainer>
                <CommentLabel>댓글</CommentLabel>
                <CommentList comments={postObj.comments}></CommentList>

                <TextInput
                    height={40}
                    value={comment}
                    onChange={(event) => {
                        setComment(event.target.value);
                    }}
                />
                <Button
                    title="댓글 작성하기"
                    onClick={(event) => commentClick(postObj.id , comment) }
                />
            </Container>
            }
        </Wrapper>
    );
```

- 위에서 전페이지에서 넘어온  `postObj.id` 를 아직 받아오지 않은 상태에서 서버에서 id 에 대한 글과 코멘트를 받아오려 하니 에러가 난다. `{ postObj.id  && }` 처럼, id가 있을때만 화면을 그려주는 로직이 있어야 한다. 



## test

- 리액트 정의, 
- 리액트의 장점이 아닌것 찾기, 
- 프로젝트 만들때 사용하는 명령어 (`npx create-react-app`), 
- 엘리먼트에 대한 설명으로 맞지 않은 것(만들어진 후엔 수정불가 - const), 
- state에 대한 설명으로 틀린것은?, 
- 리액트 컴포넌트의 생명주기 함수 3가지 : `componentDidMount`, `componentDidUpdate`, `componentWillUnmount` 
- 함수형 컴포넌트에서 생명주기를 관리하기 위해 쓰는것? 

