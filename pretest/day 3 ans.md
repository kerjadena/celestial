**Bagian A – Pilihan Ganda**
1. b. `@Entity`
2. c. Menyediakan endpoint berbasis REST
3. a. Menangani request GET ke endpoint `/user`
4. c. `findAll()`
5. a. `@ManyToOne`
6. c. `application.properties`
7. b. `@Autowired`
8. c. `@Query`
9. b. Mengambil data JSON dari body request
10. c. Mengambil data dari path endpoint

**Bagian B – Benar / Salah**
11. Benar
12. Benar
13. Salah 
14. Benar
15. Salah 

**Bagian C – Jawaban Singkat**
16. 
@Controller , Untuk MVC (mengembalikan view/html)
@RestController , Return data (JSON/XML), otomatis @ResponseBody

17. 
@GeneratedValue , Untuk auto generate nilai id primary key (biasanya auto-increment)

18. 
DTO (Data Transfer Object) memisahkan entitas database dengan data API , menghindari overexposure data internal, menjaga keamanan dan fleksibilitas API

19. 
Spring menggunakan Spring Data JPA method query derivation: otomatis membuat query berdasarkan nama method seperti findByUsername

20. 
@Column(name = "full_name") , Mapping field Java fullName ke kolom database full_name

**Bagian D – Analisis Kode dan Kelemahan**
21. Tidak ada @Id dan @GeneratedValue
```
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
```
22. Parameter name harus diberi @RequestParam
```
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}
```
23. 
```
@Entity
public class Customer {
    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}

@Entity
public class Order {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
```
24. Saat user akses /user/123, Spring ambil 123 dari URL pakai @PathVariable lalu kembalikan string "User ID: 123"

Output : 
User ID : 123

25. Gunakan @ExceptionHandler atau @ControllerAdvice untuk global exception handling
```
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {}

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
```
