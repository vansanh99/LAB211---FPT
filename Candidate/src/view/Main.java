/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import candidate.Managing;
import candidate.Validation;
import java.util.ArrayList;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Managing m = new Managing();
        ArrayList<Candidate> candidates = new ArrayList<>();
        candidates.add(new Fresher(2020, "good", "fpt", "2", "test", "1", 2000, "ninhbinh", "1234567890", "test1@gmail.com", 1));
        candidates.add(new Experience(3, "sing a song", "1", "test", "0", 1999, "hanoi", "0987654321", "test0@gmail.com", 0));
        candidates.add(new Intern("IT", "fall", "fpt", "3", "teat", "2", 2001, "thachthat", "1234567890", "test2@gmail.com", 2));
        while(true) {
            Validation val = new Validation();
            m.welcome();
            int option = val.checkInt("Enter your choice: ", 1, 5);
            switch(option) {
                case 1: {
                    m.createCandidate(candidates, 0);
                    break;
                }
                case 2: {
                    m.createCandidate(candidates, 1);
                    break;
                }
                case 3: {
                    m.createCandidate(candidates, 2);
                    break;
                }
                case 4: {
                    m.searching(candidates);
                    break;
                }
                case 5: {
                    return;
                }
            }
        }
    }
    
}
