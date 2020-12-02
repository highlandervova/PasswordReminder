package main;

import bean.Record;
import dao.RecordDao;
import service.AskService;

public class Main {
    public static void main(String[] args) {
        //ask what user wants
        String userDecision = AskService.whatUserWants();
        //get and print result
        while (true) {
            switch (userDecision) {
                case "a":
                    Record r = new Record(0, "google.com", "alex", "alex");
                    RecordDao.add(r);
                    break;
                case "e":
                System.exit(0);
            }
        }
    }
}
