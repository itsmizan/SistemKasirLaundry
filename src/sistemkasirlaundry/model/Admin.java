package sistemkasirlaundry.model;

import sistemkasirlaundry.data.DataStore;

public class Admin {
    private int idAdmin;
    private String nama;
    private String username;
    private String password;

    public Admin(int idAdmin, String nama, String username, String password) {
        this.idAdmin = idAdmin;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    /** Mengembalikan true jika username & password cocok dengan admin ini. */
    public boolean login(String username, String password) {
        boolean berhasil = this.username.equals(username) && this.password.equals(password);
        if (berhasil) {
            DataStore.setAdminAktif(this);
        }
        return berhasil;
    }

    public void logout() {
        DataStore.setAdminAktif(null);
    }

    public int getIdAdmin() { return idAdmin; }
    public void setIdAdmin(int idAdmin) { this.idAdmin = idAdmin; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
