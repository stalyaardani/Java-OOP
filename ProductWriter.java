package com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;

public class ProductWriter {
    private DataAccessor dataAccessor;

    public ProductWriter(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void insertData() {
        Scanner input = new Scanner(System.in);

        System.out.print("ID : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("NAMA : ");
        String name = input.nextLine();

        System.out.print("HARGA : ");
        double price = input.nextDouble();

        System.out.print("STOK : ");
        int stok = input.nextInt();

        try {
            String query = "INSERT INTO `tb_product` (`ID`, `NAMA`, `HARGA`, `STOK`) VALUES ('" + id + "', '" + name + "', '" + price + "', '" + stok + "') ";
            dataAccessor.executeUpdate(query);
            System.out.println("Data successfully inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // input.close();
        }
    }
}
