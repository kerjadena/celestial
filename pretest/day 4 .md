## 📄 **PRE-TEST** – _Java Spring Boot & Spring Security_

### ✳️ Bagian 1: Pilihan Ganda (Dasar)

1. Apa anotasi yang digunakan untuk mendefinisikan sebuah REST controller?
 C. `@RestController`

2. Di Spring, anotasi apa yang digunakan untuk menyuntikkan dependency ke dalam class?
 A. `@Autowired`

3. Di lapisan arsitektur Spring, Service berfungsi untuk:

- A. Menangani permintaan HTTP
 D. Menyimpan logika bisnis

4. Class model di Java Spring biasanya digunakan untuk:
 C. Menyimpan struktur data (seperti data user, produk, dll.)

5. Jika kita ingin membuat method yang bisa diakses oleh endpoint `/hello`, anotasi apa yang digunakan?
 C. `@GetMapping("/hello")`  

---

### ✳️ Bagian 2: Benar / Salah

6. SALAH
`@Service` digunakan untuk menandai class sebagai lapisan Controller.

7. BENAR
Kita bisa membuat class model tanpa anotasi apapun jika hanya digunakan sebagai POJO.

8. BENAR
`@Autowired` bisa digunakan di constructor maupun field.

9. SALAH
Spring Boot membutuhkan file `application.yml` agar bisa berjalan.

10. SALAH
`@GetMapping` hanya bisa digunakan di class dengan anotasi `@Service`.

---

### ✳️ Bagian 3: Isian Singkat

11. Anotasi apa yang digunakan agar method bisa menangani permintaan POST?

@PostMapping

12. Apa nama file konfigurasi default di Spring Boot?

application.properties atau application.yml

13. Apa yang dimaksud dengan Dependency Injection?

mekanisme dimana Spring mengelola dan menyuntikkan dependencies ke dalam class secara otomatis

14. Bagaimana cara mendeklarasikan class `UserService` agar dikenali Spring sebagai Service?

menggunakan anotasi @Service di atas class UserService

15. Apa perbedaan `@RestController` dan `@Controller`?

@RestController = mengembalikan data JSON/XML

@Controller = mengembalikan view (template,HTML)

---

### ✳️ Bagian 4: Perbaiki Kode / Output

16. Perbaiki kode berikut agar dapat dijalankan sebagai Controller:

```java
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```
PERBAIKAN :
```
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
```
17. Perbaiki kesalahan pada model berikut:

```java
public class Product {
    private String name;
    private int price;
}
```
PERBAIKAN :
```
@Data
public class Product {
    private String name;
    private int price;
}
```

18. Apa output dari method berikut?

```java
@GetMapping("/sum")
public int sum() {
    return 2 + 3;
}
```
Outuputnya jumlah dari penambahan yaitu 5

19. Kode service berikut error. Apa yang salah?

```java
@Service
public class UserService {
    private UserRepository userRepository;
}
```
UserRepository nya belum di inject
PERBAIKAN :
```
@Service
public class User Service {
    private final UserRepository;

    @AutoWired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}

20. Apa masalah pada potongan kode berikut?

```java
@RestController
public class BookController {

    @GetMapping
    public String listBooks() {
        return "books";
    }
}
```
URL mapping kosong pada @GetMapping
PERBAIKAN :
```
@RestController
public class BookController {

    @GetMapping("/books")
    public String listBooks(){
        return "books";
    }
}
---

### 🔐 Bagian 5: Spring Security

#### Pilihan Ganda

21. Apa anotasi yang digunakan untuk mengaktifkan Spring Security di aplikasi Spring Boot?
C. `@EnableWebSecurity`

22. Komponen mana yang bertugas mengatur izin akses berdasarkan role atau otorisasi di Spring Security?
D. `HttpSecurity

23. Untuk membuat otentikasi berbasis user login yang dikustomisasi, interface apa yang harus diimplementasi?
C. `UserDetailsService`

#### Benar / Salah

24. SALAH
Spring Security hanya bisa digunakan untuk REST API yang menggunakan JWT.

25. BENAR
`@PreAuthorize("hasRole('ADMIN')")` digunakan untuk membatasi method agar hanya bisa diakses oleh pengguna dengan role ADMIN.

26. BENAR
`BCryptPasswordEncoder` digunakan untuk mengenkripsi password agar tidak disimpan dalam bentuk plain text.

#### Isian Singkat

27. Apa class konfigurasi yang umum dibuat untuk menyesuaikan aturan login, logout, dan authorization di Spring Security?

SecurityConfig bisanya class konfigurasi dengan @Configuration dan @EnableWebSecurity

28. Apa anotasi yang digunakan agar method hanya bisa diakses jika pengguna memiliki hak tertentu?

@PreAuthorize

#### Perbaiki Kode / Analisis

29. Perbaiki potongan konfigurasi ini:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    return http.build();
}
```
PERBAIKAN :
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .antMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated())
        .formLogin();
    return http.build();
}


30. Apa yang salah dengan konfigurasi login berikut?

```java
http
  .authorizeHttpRequests()
  .anyRequest().permitAll()
  .and()
  .formLogin();
```
permitAll membuat semua orang bisa akses
PERBAIKAN :
```
http
  .authorizeHttpRequests()
  .anyRequest().authenticated()
  .and()
  .formLogin();
```

---
