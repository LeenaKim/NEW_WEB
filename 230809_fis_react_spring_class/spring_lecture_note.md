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