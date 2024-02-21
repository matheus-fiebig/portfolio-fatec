public class App {
    public static void main(String[] args) throws Exception {
        Reclamacao r = new Reclamacao();
        r.reclamar();

        JovemReclamacao jr = new JovemReclamacao();
        jr.reclamar();
    }
}
