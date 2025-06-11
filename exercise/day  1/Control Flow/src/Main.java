//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int a = -8 ;
        if (a > 0) {
            System.out.println("Bilangan bilangan positif");
        }else if (a<0) {
            System.out.println("Bilangan bilangan negatif");
        }else { System.out.println("Ini adalah angka 0");
        }

        int hari = 9;
        switch (hari) {
            case 1 :
                System.out.println("Hari senin");
                break;
            case 2 :
                System.out.println("Hari selasa");
                break;
            case 3 :
                System.out.println("Hari rabu");
                break;
            case 4 :
                System.out.println("Hari kamis");
                break;
            case 5 :
                System.out.println("Hari jumat");
                break;
            case 6 :
                System.out.println("Hari sabtu");
                break;
            case 7 :
                System.out.println("Hari minggu");
                break;
            default:
                System.out.println("Masukkan angka 1-7");

                // while loop

                int i = 0;
                while (i < 5) {
                    System.out.println("Perulangan ke-" + i);
                    i++;
                }

                // do while loop
                int j = 0;
                do {
                    System.out.println("Perulangan ke-" + j);
                    j++;
                } while (j < 5);
        }
    }
}