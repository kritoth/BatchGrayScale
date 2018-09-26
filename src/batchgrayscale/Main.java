package batchgrayscale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tians
 */
public class Main {
    public static void main(String[] args){
//        BatchGrayscale bg = new BatchGrayscale();
//        bg.selectConvertAndSaveMany();
        BatchInversions bi = new BatchInversions();
        bi.selectConvertAndSaveMany();
    }
}
