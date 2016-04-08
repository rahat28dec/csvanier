/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteryticketgenerator;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class LottoDemo {

    public static void main(String[] args) {
        Selection winningDraw = new Selection();

        Ticket t = new Ticket("Betty",6);
        t.setWinningDraw(winningDraw);
        
        System.out.println(t.toString());

    }
}
