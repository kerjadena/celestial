## 📘 **PRETEST **

---

### 🔹 A. **Pilihan Ganda (20 Soal)**

#### ✅ Spring Boot Security

1. Anotasi yang digunakan untuk mengaktifkan Spring Security:
    B. `@EnableWebSecurity`

2. Apa itu `AuthenticationManager` dalam Spring Security?
    B. Class yang memproses autentikasi user

3. Apa peran dari `@PreAuthorize("hasRole('ADMIN')")`?
    C. Membatasi akses method hanya untuk ADMIN

4. Class `UserDetails` diimplementasikan untuk...?
    C. Representasi user dalam security context

5. Library umum untuk hashing password di Spring Security:
    C. BCrypt
---

#### 🌐 Basic REST API (Spring Web)

6. Anotasi `@RestController` adalah gabungan dari...?
    C. `@Controller` + `@ResponseBody` 
  
7. HTTP method `PUT` biasanya digunakan untuk...?
    B. Mengupdate atau mengganti resource

8. Jika Anda ingin mengambil parameter dari `/product/{id}`, Anda akan menggunakan...?
   `C. `@PathVariable

9. Untuk membaca JSON body dan mengonversinya ke object Java, kita gunakan...?
    B. `@RequestBody`

10. Kode status HTTP yang sesuai untuk `Resource Not Found`:
    C. 404
---

#### 🧩 Spring Data JPA

11. Anotasi `@Entity` di JPA digunakan untuk...?
    B. Menandai class sebagai table di database

12. Apa tujuan dari `@Id` dalam entity class?
    C. Menandai primary key

13. Anotasi `@GeneratedValue(strategy = GenerationType.IDENTITY)` digunakan untuk...?
    C. Membiarkan database membuat ID otomatis

14. Apa peran `JpaRepository` dalam Spring Data?
    C. Abstraksi akses data CRUD

15. Relasi One-to-Many di JPA ditandai dengan...?
    C. `@OneToMany`
---

#### 🧪 Unit Testing

16. Apa anotasi JUnit 5 untuk membuat method menjadi test unit?
    C. `@Test`

17. Mockito digunakan untuk...?
    C. Membuat object palsu (mock)

18. `@MockBean` biasanya digunakan di...?
    B. Test berbasis Spring context

19. `MockMvc` berguna untuk...?
    C. Menguji controller REST tanpa menjalankan server

20. Apa tujuan dari anotasi `@BeforeEach`?
    B. Setup sebelum setiap test method
---

### 🔸 B. **Benar / Salah (10 Soal)**

21. Spring Security secara default memblokir semua endpoint.
    BENAR
22. `@PathVariable` digunakan untuk membaca data dari query parameter.
    SALAH
23. `JpaRepository` menyediakan method seperti `findAll()` dan `save()`.
    BENAR
24. `@GeneratedValue` dapat digunakan bersama `@Id`.
    BENAR
25. Spring Boot membutuhkan konfigurasi manual untuk mapping JSON ke class.
    SALAH
26. `@RestController` hanya bisa digunakan untuk GET request.
    SALAH
27. `BCryptPasswordEncoder` menghasilkan hash yang konsisten tanpa salt.
    SALAH
28. Penamaan variable sebaiknya camelCase.
    BENAR
29. Nama class di Java sebaiknya menggunakan PascalCase.
    BENAR
30. `assertEquals(expected, actual)` digunakan untuk membandingkan dua nilai dalam unit test.
    BENAR

---

### 🧾 C. **Isian Singkat (5 Soal)**

31. Apa perbedaan antara `@RestController` dan `@Controller`?
    @Controller digunakan untuk aplikasi web berbasis view (MVC), biasanya mengembalikan halaman HTML 
    @RestController adalah gabungan dari @Contoller dan @ResponseBody, sehingga seluruh metode di dalamnya secara default mengembalikan data (biasanya JSON atau XML)
32. Jelaskan fungsi `@ManyToOne` dan contoh penggunaannya dalam relasi data.
    @ManyToOne digunakan untuk mendefinisikan relasi dimana banyak entitas berhubung ke satu entitas

    contoh : banyak produk bisa berada di dalam category yang sama
    @Entity
    public class Product {
        @ManyToOne Category category;
    }

33. Apa itu `principal` dalam konteks Spring Security?
    representasi dari user yang sedang terautentikasi dalam sistem keamanan, biasanya digunakan untuk mendapatkan informasi user yang sedang login
34. Sebutkan dua konvensi penamaan dalam Java (untuk class dan variable).
    Class : PascalCase( huruf awal setiap kata kapital)
    contoh :UserService, ProductController
    Variabel/method : camelCase (huruf pertama kecil, kata berikutnya kapital)
    contoh : userService, productList
35. Mengapa penting menggunakan mocking saat membuat unit test?
    mocking digunakan untuk mengganti dependensi eksternal dengan objek tiruan, dengan menggunakan mocking unit test menjadi lebih cepat dan bisa fokus kepada satu logika unit yang sedang diuji

---

### 🔧 D. **Koreksi Kode (5 Soal)**

36.

```java
@Entity
public class Product {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
```
Field id tidak diberi anotasi @Id
Di JPA, setiap entity wajib punya primary key yang ditandai @Id

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}


37.

```java
@GetMapping("/user/{id}")
public User getUser(@RequestParam Long id) {
    ...
}
```

Endpoint menggunakan path variable (/user/{id}), tapi parameter diambil pakai @RequestParam.
Harusnya pakai @PathVariable agar bisa membaca dari URL path.

@GetMapping("/user/{id}")
public User getUser(@PathVariable Long id) {
    ...
}



38.

```java
@PostMapping("/register")
public String registerUser(User user) {
    ...
}
```
Tidak ada anotasi @RequestBody, jadi Spring tidak tahu bahwa data JSON dari request body harus di-convert ke object User.

@PostMapping("/register")
public String registerUser(@RequestBody User user) {
    ...
}


39.

```java
@Mock
UserService userService = new UserServiceImpl();
```
@Mock tidak boleh dipakai bersamaan dengan inisialisasi object.
Mockito akan menginisialisasi objek mock secara otomatis.

@Mock
private UserService userService;

40.

```java
public class userService {
    public void saveUser(User user) { ... }
}
```
Nama class tidak mengikuti konvensi Java (seharusnya PascalCase).
Nama class harus diawali huruf kapital.

public class UserService {
    public void saveUser(User user) { ... }
}

---
