package com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;

public class ProductEditor {
    private DataAccessor dataAccessor;

    public ProductEditor(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void editData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID data yang akan diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk NAMA: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk HARGA: ");
        double price = scanner.nextDouble();

        System.out.print("Masukkan nilai baru untuk JUMLAH: ");
        int stock = scanner.nextInt();

        try {
            String query = "UPDATE `tb_product` SET `NAMA` = '" + name + "', `HARGA` = " + price + ", `STOK` = " + stock + " WHERE `tb_product`.`ID` = " + id;
            dataAccessor.executeUpdate(query);
            System.out.println("Data berhasil diperbarui");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
            // scanner.close();
        }
    }
}