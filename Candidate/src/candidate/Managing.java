/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

/**
 *
 * @author pc
 */
public class Managing {

    Validation val = new Validation();

    public void welcome() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM\n"
                + "\n"
                + "1. Experience\n"
                + "2. Fresher\n"
                + "3. Internship\n"
                + "4. Searching\n"
                + "5. Exit\n"
                + "\n"
                + " (Please choose 1 to Create Experience Candidate, \n"
                + "2 to Create Fresher Candidate, 3 to Internship Candidate, \n"
                + "4 to Searching and 5 to Exit program).\n");
    }
//create candidate with common attributes

    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        do {
            System.out.print("Enter id: ");
            String id = val.checkInputString();
            if (val.isExists(candidates, id) != -1) {
                System.err.println("this id is existed. try another one.");
                continue;
            }
            System.out.print("Enter first name: ");
            String firstName = val.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = val.checkInputString();
//            System.out.println("Enter birth date: ");
            int birthDate = val.checkInt("Enter birth date: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = val.checkInputString();
            System.out.print("Enter phone: ");
            String phone = val.checkPhoneNumber();
            System.out.print("Enter email: ");
            String email = val.checkEmail();
            //add all info to candidate
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            switch (type) {
                case 0: {
                    createExperience(candidates, candidate);
                    break;
                }
                case 1: {
                    createFresher(candidates, candidate);
                    break;
                }
                case 2: {
                    createIntern(candidates, candidate);
                    break;
                }
            }
        } while (val.checkTF("Do you want to continue? Y/N ", "Y", "N"));
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
//        System.out.print("Enter year of experience: ");
        int expInYear = val.checkInt("Enter year of experience: ", 0, Calendar.getInstance().get(Calendar.YEAR) - candidate.getBirthDate());
        System.out.print("Enter Professional Skill: ");
        String proSkill = val.checkInputString();
        candidates.add(new Experience(expInYear, proSkill, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.out.println("Successfully");
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
//        System.out.print("Enter graduated time: ");
        int graduateDate = val.checkInt("Enter graduated time: ", 1920, Calendar.getInstance().get(Calendar.YEAR) + 20);
        System.out.print("Enter rank of graduation: ");
        String graduationRank = val.checkGraduationRank();
        System.out.print("Enter University: ");
        String education = val.checkInputString();
        candidates.add(new Fresher(graduateDate, graduationRank, education, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.out.println("Successfully");
    }

    public void createIntern(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter majors: ");
        String major = val.checkInputString();
        System.out.print("Enter semester: ");
        String semester = val.checkInputString();
        System.out.print("Enter university name: ");
        String university = val.checkInputString();

        candidates.add(new Intern(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.out.println("Successfully");
    }

    public void displayAllCandidates(ArrayList<Candidate> candidates) {
        Collections.sort(candidates);
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getType());
        }
        int countT0 = 0;
        int countT1 = 0;
        int countT2 = 0;
        System.out.println("List of candidate:\n");
        for (Candidate candidate : candidates) {

            if (candidate.getType() == 0) {
                //count for number of experience
                if (++countT0 == 1) {
                    System.out.println("===========EXPERIENCE CANDIDATE============\n");
                }
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());

            }

            if (candidate.getType() == 1) {
                //count for number of fresher
                if (++countT1 == 1) {
                    System.out.println("===========FRESHER CANDIDATE===============\n");
                }
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());

            }

            if (candidate.getType() == 2) {
                //count for number or INtern
                if (++countT2 == 1) {
                    System.out.println("===========INTERN CANDIDATE================\n");
                }
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());

            }
        }
//        //reset counter
//        count = 0;
//        for (Candidate candidate : candidates) {
//            if (candidate instanceof Fresher) {
//                //count for number of fresher
//                count += 1;
//                if (count == 1) {
//                    System.out.println("===========FRESHER CANDIDATE===============\n");
//                }
//                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
//
//            }
//            if (candidate instanceof Intern) {
//                //count for number or INtern
//                count += 1;
//                if (count == 1) {
//                    System.out.println("===========INTERN CANDIDATE================\n");
//                }
//                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
//
//            }
//        }
//        //reset counter
//        count = 0;
//        for (Candidate candidate : candidates) {
//            if (candidate instanceof Intern) {
//                //count for number or INtern
//                count += 1;
//                if (count == 1) {
//                    System.out.println("===========INTERN CANDIDATE================\n");
//                }
//                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
//
//            }
//        }
    }

    public void searchCandidate(ArrayList<Candidate> candidates) {
        System.out.println("Input Candidate name (First name or Last name): ");
        String keyword = val.checkInputString();
//        System.out.println("Input type of candidate: ");
        int type = val.checkInt("Input type of candidate: ", 0, 2);
        //count for number of candidates found
        int count = 0;
        for (Candidate candidate : candidates) {
            if (count == 1) {
                System.out.println("The candidates found:");
            }
            if ((candidate.getFirstName().toLowerCase().contains(keyword.toLowerCase())
                    || candidate.getLastName().toLowerCase().contains(keyword.toLowerCase()))
                    && candidate.getType() == type) {
                count++;
                System.out.println(candidate.toString());
            }
        }
        if (count == 0) {
            System.err.println("No candidate found");
        }
    }

    public void searching(ArrayList<Candidate> candidates) {
        if (candidates.isEmpty()) {
            System.err.println("there is no candidate to find.");
            return;
        }
        displayAllCandidates(candidates);
        searchCandidate(candidates);
    }
}
