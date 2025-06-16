## 📄 Pretest Spring Boot Security & Unit Testing\*\*

### ✅ **A. Pilihan Ganda (12 Soal)**

1. Apa tujuan utama dari Spring Security?
    Untuk menyediakan autentikasi dan otorisasi pada aplikasi java

2. Apa anotasi untuk mengaktifkan Web Security di Spring Boot?
    @EnableWebSecurity

3. Apa fungsi `HttpSecurity` dalam konfigurasi Spring Security?
    Untuk mengatur keamanan HTTP

4. Apa itu prinsip _Authentication Principal_ dalam Spring Security?
    Objek yang memrepresentasikan user yang sudah di autentikasi, biasanya dengan akses @AuthenticationPrincipal

5. Apa peran dari anotasi `@PreAuthorize("hasRole('ADMIN')")`?
    Membatasi akses ke method hanya untuk user dengan role ADMIN

6. Apa fungsi dari class `UserDetails` di Spring Security?
    Merepresentasikan detail user untuk proses autentikasi

7. Apa itu BCrypt?
    Algoritma hash password yang aman, digunakan oleh BCryptPasswordEncoder

8. Library utama yang digunakan untuk testing unit di Spring Boot adalah:
    JUnit

9. Apa kegunaan dari `@MockBean` dalam Spring Boot Test?
    Untuk menyuntikkan mock bean ke dalam ApplicationContext saat testing

10. Apa yang dilakukan oleh anotasi `@WithMockUser`?
    Menyimulasikan user login dengan role tertentu saat melaksanakan unit test

11. Apa perbedaan mendasar antara `@WebMvcTest` dan `@SpringBootTest`?
    @WebMvcTest hanya load web layer, @SpringBootTest load full context

12. Apa tujuan dari anotasi `@BeforeEach` dalam unit test?
        Menjalankan method setup sebelum test method

---

### ✅ **B. Benar/Salah (5 Soal)**

13. `BCryptPasswordEncoder` menghasilkan hash yang sama untuk password yang sama.
    SALAH

14. Spring Security dapat digunakan untuk endpoint berbasis REST API maupun form login.
    BENAR

15. `@WebMvcTest` bisa digunakan untuk menguji layer service dan repository.
    SALAH

16. `Principal` adalah representasi dari user yang sedang login.
    BENAR
17. `@MockBean` dan `@Mock` memiliki efek yang sama dalam Spring Boot Test.
    SALAH
---

### ✅ **C. Isian Singkat (5 Soal)**

18. Apa peran dari `AuthenticationManager` dalam Spring Security?
    Handle proses autentikasi, mengecek kredensial user

19. Jelaskan apa yang dilakukan oleh `PasswordEncoder` dan kenapa penting?
    Untuk hash password sebelum disimpan, agar password aman

20. Apa yang dimaksud dengan "authorization" dalam konteks aplikasi?
    Proses pengecekan apakah user punya akses atau tidak

21. Apa itu _test double_, dan apa perbedaannya dengan _mock_ di unit test?
    Test Double :Objek pengganti komponen asli, mock : test double yang dikontrol perilakunya

22. Dalam pengujian REST API Spring Boot, apa fungsi utama `MockMvc`?
    Untuk menyimulasikan HTTP request ke controller secara unit test tanpa server sungguhan

---

### ✅ **D. Koreksi Kode (8 Soal)**

Perhatikan kode berikut dan jelaskan apa yang salah.

23.

```java
@Autowired
private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
```

JAWABAN :
@Autowired
private PasswordEncoder passwordEncoder;

24.

```java
@WithMockUser(username = "user", roles = "USER")
@Test
void testAccessAdminEndpoint() {
    mockMvc.perform(get("/admin")).andExpect(status().isOk());
}
```

JAWABAN:
@WithMockUser(username = "user", roles = "ADMIN")
@Test
void testAccessAdminEndPoint() {
    mockMvc.perform(get("/admin)).andExpect(status().isOk());
}
25.

```java
@Mock
UserService userService = new UserServiceImpl();
```

JAWABAN:
@Mock
UserService userService;

26.

```java
@SpringBootTest
@WebMvcTest
public class MyTest {
}
```

JAWABAN:
@WebMvcTest
public class MyTest {
}

27.

```java
@Test
void testPasswordHash() {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    assertEquals("mypassword", encoder.encode("mypassword"));
}
```

JAWABAN:
@Test
void testPasswordHash(){
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    assertTrue(encoder.matches("mypassword", encoder.encode("mypassword")));
}

28.

```java
@Test
void testUnauthorizedAccess() {
    mockMvc.perform(get("/secure-data"))
           .andExpect(status().isOk());
}
```

JAWABAN:
@Test
void testUnauthorizedAccess() {
    mockMvc.perform(get("/secure-data"))
    .andExpect(status().inUnauthorized());
}

29.

```java
@BeforeAll
void setup() {
    MockitoAnnotations.openMocks(this);
}
```
JAWABAN:
@BeforeAll
static void setup() {
    MockitoAnnotations.openMocks(this);
}

30.

```java
@Test
void testLogin() {
    when(authService.login("user", "pass")).thenReturn(null);
    assertNotNull(authService.login("user", "pass"));
}
```

JAWABAN:
@Test
void testLogin(){
    Object expectedValue = new Object(); 
    when(authService.login("user", "pass")).thenReturn(expectedValue);
    assertNotNull(authService.login("user", "pass"));
}
