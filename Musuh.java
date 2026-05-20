public abstract class Musuh {

    protected String namaMusuh;
    protected int healthPoint;

    public Musuh(String nama, int hp) {
        this.namaMusuh = nama;
        this.healthPoint = hp;
    }

    public void terimaDamage(int damage) {
        this.healthPoint -= damage;

        System.out.println(this.namaMusuh
                + " terkena serangan. Sisa HP: "
                + this.healthPoint);
    }

    public abstract void serangPemain();

    public abstract void suaraKhas();
}