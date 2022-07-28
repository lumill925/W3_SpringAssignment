# w3_SpringAssignment

### 수정,삭제 API의 request를 어떤 방식으로 사용하셨나요?
  - 수정  
     @PathVariable을 통해 포스트의 기본 키 값인 id를 받고, 포스트의 데이터를 @RequestBody로 받아  DB에 저장된 비밀번호와 입력받은 비밀번호가 같은 경우 수정 되도록 하였다.
  - 삭제
     @PathVariable로 id를 받아, 해당 id값을 가진 데이터를 db에서 찾아 비밀번호가 일칠할 경우 삭제되도록 하였다.

### 어떤 상황에 어떤 방식의 request를 써야하나요?
   - Create  
     Create는 서버에 정보를 올려달라는 요청입니다. POST 메서드를 사용해 요청합니다.
     POST를 통해 해당 URI을 요청하면 리소스를 생성합니다.
   - Read  
     Read는 서버에서 정보를 불러오는 요청입니다. GET 메서드를 사용해 요청합니다. GET을 통해 해당 리소스를 조회합니다. 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져옵니다.
   - Update  
     Update는 정보를 바꾸는 요청입니다. 상황에 따라 PUT 메서드와 PATCH 메서드를 사용해 요청합니다. PUT은 데이터 전체를 바꾸고 싶을 때, PATCH는 데이터의 일부만 수정하고 싶을 때 사용합니다.
   - Delete  
     Delete는 정보를 지우는 요청입니다. DELETE 메서드를 사용해 요청합니다. 리소스를 삭제할 수 있습니다.

### RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?

   - REST API 설계
     - 자원에 대한 행위는 HTTP Method로 표현한다.
     - URI(Uniform Resource Identifier, 자원을 나타내는 유일한 주소)는 정보의 자원을 표현해야 한다.
       - Rule1. 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용한다. 
       - Rule2. URI 마지막 문자로 슬래시 구분자(/)를 사용하지 않는다.
       - Rule3. 가독성을 높이기 위해 _(언더바)가 아닌 -(하이픈)을 사용한다.
       - Rule4. URI 경로에는 소문자가 적절하다.
       - Rule5. 파일 확장자는 URI에 포험하지 않는다.
       - Rule6. 기본적으로 명사를 사용하지만, 컨트롤 자원을 의미하는 경우 동사를 허용한다.
       - Rule7. 리소스 간 연관 관계가 있는 경우 {}를 통해 처리한다.
  
   URI규칙을 지키면서 설계하려고 노력했다. CRUD중 Create을 제외한 나머지는 기본 키 값인 id를 받아 처리했기 때문에 동일한 path를 적용하였는데 좀 더 확실하게 나눌수 있는 방법이 있지 않을까 하는 생각이 들었다. REST는 표준이 없는 만큼 아무것도 모르는 사람이 봤을 때도 바로 이해할 수 있도록 설계단계에 신경을 써야할 것 같다.
   
### 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)

   - Controller  
      Controller에서는 @Controller에 @ResponseBody가 추가된 @RestController를 사용하였다. 이는 JSON 형태로 객체 데이터를 반환한다. 그리고 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping으로 각각의 CRUD 기능을 구현하였다.
   - Repository  
      Repository에서는 JPA를 사용해 DB에 접근할 수 있도록 하였다. 
   - Service  
      Service에서는 비즈니스 로직 수행을 위한 것들이 포함되어있다. Controller에 들어온 요청 수행에 도움을 준다.

### 작성한 코드에서 빈(Bean)을 모두 찾아보세요!

@Entity,
@NoArgsConstructor,
@Getter,
@Column,
@MappedSuperclass,
@EntityListeners,
@CreatedDate,
@LastModifiedDate,
@RequiredArgsConstructor,
@RestController,
@PostMapping,
@GetMapping,
@DeleteMapping,
@PutMapping,
@Service,
@Transactional,
@EnableJpaAuditing,
@SpringBootApplication

### API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요!
 
 ### API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요!

| Method | URL | Request | Response |
| --- | --- | --- | --- |
| GET | /api/postings |  |  |
| GET | /api/postings/{id} | |  |
| POST | /api/postings | {'title':'title', 'username':'username', 'password':'password', 'contents':'contents'} | {'title':'title', 'username':'username', 'password':'password', 'contents':'contents', 'createdAt':'createdAt', 'modifiedAt', 'modifideAt'} |
| DELETE | /api/postings/{id} |  |  |
| PUT | /api/postings/{id} |  |  |

