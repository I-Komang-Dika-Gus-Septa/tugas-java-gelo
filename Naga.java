public class Naga extends Musuh implements Bisaterbang {

    public Naga() {
        super("Ireng Boy", 500);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh
                + " terbang dan menyemburkan cairan tinta hitam! Player -50 HP");
    }

    @Override
    public void suaraKhas() {
        System.out.println("Naga: ROOAARR!");
    }

    @Override
    public void lepasLandas() {
        System.out.println(this.namaMusuh + " terbang tinggi! Sulit diserang.");
    }

    @Override
    public void serangUdara() {
        System.out.println(this.namaMusuh + " menyemburkan cairan tinta hitam! Pemain -80 HP.");
    }
}