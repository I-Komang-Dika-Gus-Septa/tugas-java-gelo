import java.util.ArrayList;
import java.util.Scanner;

public class ArenaPertarunganDinamis {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Musuh> gelombangMonster = new ArrayList<>();

        gelombangMonster.add(new Slime());
        gelombangMonster.add(new Naga());
        gelombangMonster.add(new Slime());
        gelombangMonster.add(new Zombie());

        System.out.println("----------------------------------------");
        System.out.println("        ARENA RPG: GELOMBANG MONSTER");
        System.out.println("----------------------------------------");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isBermain = true;

        while (isBermain && !gelombangMonster.isEmpty()) {

            System.out.println("\n--- STATUS MONSTER ---");

            for (int i = 0; i < gelombangMonster.size(); i++) {

                Musuh m = gelombangMonster.get(i);

                if (m.healthPoint > 0) {

                    System.out.println((i + 1) + ". "
                            + m.namaMusuh
                            + " (HP: " + m.healthPoint + ")");

                } else {

                    System.out.println((i + 1) + ". "
                            + m.namaMusuh + " [TEWAS]");
                }
            }

            System.out.println("5. Kabur dari pertarungan");
            System.out.print("\nPilih target monster: ");

            try {

                int pilihanTarget = input.nextInt();

                if (pilihanTarget == 5) {

                    System.out.println("Anda lari terbirit-birit dari arena...");
                    isBermain = false;
                    continue;
                }

                if (pilihanTarget < 1 || pilihanTarget > gelombangMonster.size()) {

                    System.out.println("Pilihan tidak valid! Anda membuang giliran.");
                    continue;
                }

                int indeksMonster = pilihanTarget - 1;

                Musuh target = gelombangMonster.get(indeksMonster);

                if (target.healthPoint <= 0) {

                    throw new TargetMatiException(
                            "Tindakan Ilegal: Anda tidak bisa menyerang monster yang sudah mati!");
                }

                System.out.print("Masukkan kekuatan serangan Anda (10-100): ");
                int power = input.nextInt();

                if (power < 10 || power > 100) {

                    throw new SeranganTidakValidException(
                            "Kekuatan serangan harus di antara 10 - 100!");
                }

                System.out.println("\n>>> HASIL SERANGAN ANDA <<<");

                target.terimaDamage(power);

                if (target.healthPoint <= 0) {

                    System.out.println(target.namaMusuh
                            + " hancur menjadi debu!");

                    if (target instanceof Bisaloot) {

                        Bisaloot loot = (Bisaloot) target;
                        loot.jatuhkanItem();
                    }

                    gelombangMonster.remove(indeksMonster);
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input, silahkan coba lagi.");
                input.nextLine();
                continue;
            }

            if (gelombangMonster.isEmpty()) {
                System.out.println("\nSELAMAT! Semua monster telah dibersihkan dari arena");
                break;
            }

            System.out.println("\n<<< GILIRAN MONSTER MEMBALAS >>>");

            for (int i = 0; i < gelombangMonster.size(); i++) {

                Musuh monsterAktif = gelombangMonster.get(i);

                monsterAktif.suaraKhas();

                if (monsterAktif instanceof Bisaterbang) {

                    System.out.println(
                            "[PERINGATAN! SERANGAN UDARA TERDETEKSI]");

                    Bisaterbang monsterTerbang =
                            (Bisaterbang) monsterAktif;

                    monsterTerbang.lepasLandas();
                    monsterTerbang.serangUdara();

                } else {

                    monsterAktif.serangPemain();
                }

                System.out.println("------------------------------------------------------");
            }
        }

        input.close();

        System.out.println("\nPermainan Berakhir.");
        System.out.println("----------------------------------------");
    }
}