package praktikum10;

class Pemain {
    String tim;
    int no;
    int tinggiBadan;
    int beratBadan;

    public Pemain(String tim, int no, int tinggiBadan, int beratBadan) {
        this.tim = tim;
        this.no = no;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    @Override
    public String toString() {
        return String.format("Tim %s - No: %d, Tinggi: %d cm, Berat: %d kg", tim, no, tinggiBadan, beratBadan);
    }
}