package com.sumroch.spotme.models.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

@Data
@NoArgsConstructor
public class Parkir {

    private String floorName;
    private int availableSpaces;
    private int maxSpaces;

    public Parkir(String floorName, int availableSpaces, int maxSpaces) {
        this.floorName = floorName;
        this.availableSpaces = availableSpaces;
        this.maxSpaces = maxSpaces;
    }

    public static List<Parkir> getDummyPArkir() {
        List<Parkir> parkirList = new ArrayList<>();

        parkirList.add(new Parkir("B1", new Random().nextInt(10), new Random().nextInt(10) + 10));
        parkirList.add(new Parkir("B2", new Random().nextInt(20), new Random().nextInt(10) + 20));
        parkirList.add(new Parkir("B3", new Random().nextInt(30), new Random().nextInt(10) + 30));
        parkirList.add(new Parkir("B4", new Random().nextInt(40), new Random().nextInt(10) + 40));
//        parkirList.add(new Parkir("B1", 25, 50));
//        parkirList.add(new Parkir("B2", 15, 60));
//        parkirList.add(new Parkir("B3", 15, 20));
//        parkirList.add(new Parkir("B4", 25, 50));
//        parkirList.add(new Parkir("B1", 25, 50));
//        parkirList.add(new Parkir("B2", 15, 60));
//        parkirList.add(new Parkir("B3", 15, 20));
//        parkirList.add(new Parkir("B4", 25, 50));
        return parkirList;
    }

    @Data
    @NoArgsConstructor
    public static class Request {

        private Integer idUser;
        private Integer idMall;
        private Integer idLokasi;
        private String platNomor;
        private String jenisKendaraan;
    }
}
