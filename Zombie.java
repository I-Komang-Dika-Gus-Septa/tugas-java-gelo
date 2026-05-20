public class Zombie extends Musuh implements Bisaloot {

    public Zombie() {
        super("Tempe Bacem", 150);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh +
                " merangkak dan menggigit mangsa! Player -20 HP");
    }

    @Override
    public void suaraKhas() {
        System.out.println("Zombie: Urrrggghhh...");
    }

    @Override
    public void jatuhkanItem() {
        System.out.println(this.namaMusuh +
                " menjatuhkan sebuah item! Ambillah!");
    }
}