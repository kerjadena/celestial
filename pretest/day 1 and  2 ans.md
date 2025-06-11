###
**A. Pilihan Ganda**
1. Apa yang menjadi tanggung jawab utama seorang Backend Engineer?
    B. Mengelola logika aplikasi dan komunikasi data dengan database
2. Dalam OOP Java, konsep **encapsulation** berarti:
    A. Menyembunyikan detail implementasi dan menyediakan akses lewat method
3. `@Autowired` pada Spring Boot digunakan untuk:
    C. Meng-inject dependency otomatis ke dalam bean
4. Mengapa sebaiknya logika bisnis diletakkan di service layer?
    A. Agar controller lebih ringan dan fokus pada request/response
5. Di bawah ini adalah cara yang benar membuat endpoint di Spring Boot:
    C. `@GetMapping("/api")`

**B. True / False**
6.  False
7.  True
8.  True
9.  False
10. True

**C. Jawaban Singkat Penjelasan**
11. Backend = bagian sistem yang menangani logika bisnis, database, dan server-side processing, yang biasanya tidak terlihat langsung oleh pengguna

12. Class = blueprint atau cetakan object
    Object = instance nyata dari class yang dibuat di memori

13. Inheritance: class bisa mewarisi sifat dan method dari class lain
    Polymorphism: kemampuan object punya banyak bentuk, method bisa di-override

14. @RestController dipakai di Spring Boot untuk menandai class yang berisi endpoint REST API, otomatis menggabungkan @Controller dan @ResponseBody

15. Spring Boot memudahkan setup, otomatisasi konfigurasi, punya embedded server, starter dependency, monitoring actuator, dan cepat digunakan

16. Dependency Injection di Spring Boot: Spring otomatis menyuntikkan object yang dibutuhkan ke dalam class, biasanya lewat constructor atau @Autowired

17. Agar kode modular, controller hanya handle request-response,  mudah di-maintain dan dites

18. Kalau tidak diberi @Service, Spring tidak mengenali class itu sebagai bean sehingga dependency injection tidak bisa dilakukan

19. @RequestParam dipakai untuk mengambil parameter dari query string di URL

20. Dengan constructor injection

**D. Koreksi Kode**
21. helloService belum didefinisikan & belum di-inject

@RestController
public class HelloController{
    Private final HelloService helloService;
    @Autowired
    public HelloController (HelloService hello Service) {
        this.helloService =  helloService;
    }
    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHello();
    }
}

22. constructor tidak boleh pakai void

public class Person {
    public String name;
    public Person(String name){
        this.name
    }
}

23. @RequestBody harus diikuti tipe data (String)

@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody String name){
        return "Hello, " + name;
    }
}

24. tidak boleh new service secara manual → harus pakai dependency injection

@RestController
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/info")
    public String get() {
        return infoService.getInfo();
    }
}

25. parameter HTTP GET butuh anotasi @RequestParam

@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) {
        return a+b;
    }
}