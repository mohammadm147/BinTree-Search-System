
/**
 * World Class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-19-09
 */
public class SeminarDB {

    private BST<Integer, Seminar> idTree;
    private BST<Integer, Seminar> costTree;
    private BST<String, Seminar> dateTree;
    private BST<String, Seminar> keywordTree;
    private BST location;

    // create binary search trees for various search commands

    /**
     * Seminar DB Constructor
     * 
     * @param size
     *            inputted world size
     * @param name
     *            of file
     */
    public SeminarDB(int size, String name) {
        idTree = new BST<Integer, Seminar>();
        costTree = new BST<Integer, Seminar>();
        dateTree = new BST<String, Seminar>();
        keywordTree = new BST<String, Seminar>();
        location = new BST();
    }


    /**
     * Inserts seminar object into each of the trees
     * 
     * @param sem
     *            representing Seminar
     */

    public void insert(Seminar sem) {
        KVPair<Integer, Seminar> idPair = new KVPair<Integer, Seminar>(sem.id(),
            sem);
        KVPair<Integer, Seminar> costPair = new KVPair<Integer, Seminar>(sem
            .cost(), sem);
        KVPair<String, Seminar> datePair = new KVPair<String, Seminar>(sem
            .date(), sem);

        if (idTree.findValue(sem.id()) == null) {
            if (sem.x() < 0 || sem.y() < 0 || sem.x() >= 128 || sem
                .y() >= 128) {
                System.out.println("Insert FAILED - Bad x, y coordinates: "
                    + sem.x() + ", " + sem.y());
            }
            else {
                idTree.insert(idPair);
                costTree.insert(costPair);
                dateTree.insert(datePair);
                for (int i = 0; i < sem.keywords().length; i++) {
                    KVPair<String, Seminar> keywordPair =
                        new KVPair<String, Seminar>(sem.keywords()[i], sem);
                    keywordTree.insert(keywordPair);
                }

                System.out.println("Successfully inserted record with ID "
                    + sem.id());
                System.out.print(sem.toString() +"\n");
            }

        }
        else {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + sem
                    .id());
        }

    }


    /**
     * Search function for printing the record that matches the given ID
     * 
     * @param id
     *            is the id of record
     */
    public void searchID(int id) {
        if (idTree.findValue(id) != null) {
            System.out.println("Found Record with ID " + id + ":");
            Seminar sem = (Seminar)idTree.findValue(id);
            System.out.print(sem.toString());
        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
        }
    }


    /**
     * Search function that prints all records that fall within the range
     * 
     * @param low
     *            is low cost
     * @param high
     *            is high cost
     */
    public void searchCost(int low, int high) {
        System.out.println("\nSeminars with costs in range " + low + " to "
            + high + ":");
        costTree.rangeSearch(costTree.getRoot(), low, high);
    }


    /**
     * Search function for printing all records that fall within a range of
     * dates /
     * times
     * 
     * @param date1
     *            first date or time
     * @param date2
     *            second date or time
     */
    public void searchDate(String date1, String date2) {
        System.out.println("Seminars with dates in range " + date1 + " to "
            + date2 + ":");
        dateTree.rangeSearch(dateTree.getRoot(), date1,
            date2);
    }


    /**
     * Search function that prints all records that match the keyword
     * 
     * @param word
     *            for keyword
     */
    public void searchKeyword(String word) {
        System.out.println("Seminars matching keyword " + word + ":");
        keywordTree.rangeSearch(keywordTree.getRoot(), word, word);

    }


    /**
     * Search function that prints all records that fall within radius distance
     * of
     * the search point
     * 
     * @param xCoor
     *            is X coordinate
     * @param yCoor
     *            is Y coordinate
     * @param rad
     *            is the radius
     */
    public void searchLocation(int xCoor, int yCoor, int rad) {

    }


    /**
     * Deletes a record with the given ID from ALL search trees
     * 
     * @param id
     *            of record
     */
    public void delete(int id) {
        if (idTree.findValue(id) != null) {
            idTree.remove(id);
            System.out.println("Record with ID " + id
                + " successfully deleted from the database");
        }

    }


    /**
     * Depending on which print command is passed, print out a traversal of the
     * corresponding tree
     * 
     * @param command
     */
    public void print(String command) {

        if (command.equals("ID")) {
            if (idTree.size() == 0) {
                System.out.println("ID Tree:");
                System.out.println("This tree is empty");
            }
            else {
                System.out.println("ID Tree:");
                idTree.print();
                System.out.println("Number of records: " + idTree.size());
            }

        }
        if (command.equals("keyword")) {
            if (keywordTree.size() == 0) {
                System.out.println("Keyword Tree:");
                System.out.println("This tree is empty");
            }
            else {
                System.out.println("Keyword Tree:");
                keywordTree.print();
                System.out.println("Number of records: " + keywordTree.size());
            }

        }
        if (command.equals("cost")) {
            if (costTree.size() == 0) {
                System.out.println("Cost Tree:");
                System.out.println("This tree is empty");
            }
            else {
                System.out.println("Cost Tree:");
                costTree.print();
                System.out.println("Number of records: " + costTree.size());
            }

        }
        if (command.equals("date")) {
            if (dateTree.size() == 0) {
                System.out.println("Date Tree:");
                System.out.println("This tree is empty");
            }
            else {
                System.out.println("Date Tree:");
                dateTree.print();
                System.out.println("Number of records: " + dateTree.size());
            }

        }
    }
}
