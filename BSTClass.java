package Proje2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BSTClass {

    Flight root;

    public BSTClass() {
        root = null;
    }

    public ArrayList<Flight> searchPrice(int price) throws Exception {
        ArrayList<Flight> searchPrice = new ArrayList<>();
        if (root == null || root.price == price) {
            return null;
        }
        Flight temp = root;
        while (temp.price != price) {
            if (price < temp.price) {
                temp = temp.left;
                if (temp.price == price) {
                    searchPrice.add(temp);
                }
            } else {
                temp = temp.right;
                if (temp.price == price) {
                    searchPrice.add(temp);
                }

            }
            if (temp == null) {
                return null;
            }
        }
        return searchPrice;
    }

    public ArrayList<Flight> searchDateAndFrom(Date date, String firstCity) throws Exception {
        ArrayList<Flight> searchDateAndFrom = new ArrayList<>();
        Flight temp = root;
        if (root == null || temp.date.equals(date)) {
            return null;
        }
        while (temp.left != null) {
            if (date.equals(temp.date) && temp.firstCity.equals(firstCity)) { //date and from both
                searchDateAndFrom.add(temp);
            } else if (!date.equals(root.date)) {
                temp = temp.left;
                searchDateAndFrom(date, firstCity);
            }
        }
        while (temp.right != null) {
            if (date.equals(temp.date) && temp.firstCity.equals(firstCity)) {
                searchDateAndFrom.add(temp);
            } else if (!date.equals(root.firstCity)) {
                temp = temp.right;
                searchDateAndFrom(date, firstCity);
            }
        }

        return searchDateAndFrom;

    }

    public ArrayList<Flight> searchDate(Date date) throws Exception {
        ArrayList<Flight> searchDate = new ArrayList<>();
        Flight temp = root;
        if (root == null || temp.date.equals(date)) {
            return null;
        }
        while (temp.left != null) {
            if (date.equals(temp.date)) {
                searchDate.add(temp);
            } else if (!date.equals(root.date)) {
                temp = temp.left;
                searchDate(date);
            }
        }
        while (temp.right != null) {
            if (date.equals(temp.date)) {
                searchDate.add(temp);
            } else if (!date.equals(root.firstCity)) {
                temp = temp.right;
                searchDate(date);
            }
        }

        return searchDate;

    }

    public ArrayList<Flight> searchBetweenTwo(Date before, Date after) throws Exception {
        ArrayList<Flight> searchBeforeAndAfter = new ArrayList<>();
        Flight temp = root;
        if (root == null) {
            return null;
        }
        while (temp.left.date.after(before)) {
            if (before.after(temp.date)) {
                searchBeforeAndAfter.add(temp);
                temp = temp.left;
            } else {
                temp = temp.left;
                searchBetweenTwo(before, after);
            }
        }
        while (temp.right.date.before(after)) {
            if (after.before(temp.date)) {
                searchBeforeAndAfter.add(temp);
                temp = temp.right;
            } else {
                temp = temp.right;
                searchBetweenTwo(before, after);
            }
        }
        return searchBeforeAndAfter;

    }

    public ArrayList<Flight> searchDateAndPrice(Date date, int Price) throws Exception {
        ArrayList<Flight> searchDateAndPrice = new ArrayList<>();
        Flight temp = root;
        if (root == null || temp.date.equals(date)) {
            return null;
        }
        while (temp.left != null) {
            if (date.equals(temp.date) && temp.price < Price) {
                searchDateAndPrice.add(temp);
            } else if (!date.equals(root.date)) {
                temp = temp.left;
                searchDateAndPrice(date, Price);
            }
        }
        while (temp.right != null) {
            if (date.equals(temp.date) && temp.price < Price) {
                searchDateAndPrice.add(temp);
            } else if (!date.equals(root.firstCity)) {
                temp = temp.right;
                searchDateAndPrice(date, Price);
            }
        }

        return searchDateAndPrice;

    }

    public ArrayList<Flight> searchFrom(String firstCity) throws Exception {
        ArrayList<Flight> searchFrom = new ArrayList<>();
        Flight temp = root;
        if (root == null || temp.firstCity.equals(firstCity)) {
            return null;
        }
        while (temp.left != null) {
            if (firstCity.equals(temp.firstCity)) {
                searchFrom.add(temp);
            } else if (!firstCity.equals(root.firstCity)) {
                temp = temp.left;
                searchFrom(firstCity);
            }
        }
        while (temp.right != null) {
            if (firstCity.equals(temp.firstCity)) {
                searchFrom.add(temp);
            } else if (!firstCity.equals(root.firstCity)) {
                temp = temp.right;
                searchFrom(firstCity);
            }
        }
        return searchFrom;
    }

    public void insertPrice(int price) throws Exception {
        Flight fly = new Flight();
        if (root == null) {
            root = fly;
        } else {
            Flight tmp = root;
            Flight parent = root;

            while (tmp != null) {
                parent = tmp;
                if (price < tmp.price) {
                    tmp = tmp.left;
                } else if (price > tmp.price) {
                    tmp = tmp.right;
                }
            }
            if (price < parent.price) {
                parent.left = fly;
            } else {
                parent.right = fly;
            }
        }
    }

    public void insertDate(Date date) throws Exception {
        Flight fly = new Flight();
        if (root == null) {
            root = fly;
        } else {
            Flight tmp = root;
            Flight parent = root;

            while (tmp != null) {
                parent = tmp;
                if (date.before(tmp.date)) {
                    tmp = tmp.left;
                } else if (date.after(tmp.date)) {
                    tmp = tmp.right;
                }
            }
            if (date.before(parent.date)) {
                parent.left = fly;
            } else {
                parent.right = fly;
            }
        }
    }

    public void insertFrom(String firstCity) throws Exception {
        Flight fly = new Flight();
        int i = 0;
        if (root == null) {
            root = fly;
        } else {
            Flight tmp = root;
            Flight parent = root;

            while (tmp != null) {
                parent = tmp;
                if ((int) firstCity.charAt(i) < (int) tmp.firstCity.charAt(i)) {
                    tmp = tmp.left;
                } else if ((int) firstCity.charAt(i) > (int) tmp.firstCity.charAt(i)) {
                    tmp = tmp.right;
                } else if ((int) firstCity.charAt(i) == (int) tmp.firstCity.charAt(i)) {
                    i++;
                }
            }

            int n = 0;
            boolean x = true;
            while (x = true) {
                if ((int) firstCity.charAt(n) < (int) parent.firstCity.charAt(n)) {
                    parent = parent.left;
                } else if ((int) firstCity.charAt(n) > (int) parent.firstCity.charAt(n)) {
                    parent = parent.right;
                } else if ((int) firstCity.charAt(n) == (int) parent.firstCity.charAt(n)) {
                    n++;
                    x = true;
                }
            }

        }

    }

    public void remove(Date date) throws Exception, NullPointerException {
        Flight deleted = root;
        Flight parent = root;
        boolean isleft = true;
        //no child
        if (deleted.left == null && deleted.right == null) {
            if (deleted == root) {
                root = null;
            } else if (isleft = true) {
                parent.left = null;
            } else if (isleft = false) {
                parent.right = null;
            }
        }//one child
        else if (deleted.right == null) {
            if (deleted == root) {
                root = deleted.left;
            } else if (isleft == true) {
                parent.left = deleted.left;
            } else if (isleft == false) {
                parent.right = deleted.left;
            }
        } else if (deleted.left == null) {
            if (deleted == root) {
                root = deleted.right;
            } else if (isleft == true) {
                parent.left = deleted.right;
            } else if (isleft == false) {
                parent.right = deleted.right;
            }
        }//two child
        else {
            Flight temp = deleted.right;
            while (temp.left != null) {//min val after itself
                temp = temp.left;
            }
            Flight minValue = temp;
            if (deleted == root) {
                deleted = minValue;
            } else if (isleft == true) {
                parent.left = minValue;
            } else {
                parent.right = minValue;
                minValue.left = deleted.left;
            }
        }
    }

//    public void createNewFile() throws IOException, NullPointerException, Exception {
//        Flight current = root;
//        File info = new File("FlightInformation.txt");
//        BufferedWriter br = new BufferedWriter(new FileWriter(info));
//        br.write("Date:" + " " + current.date);
//        br.newLine();
//        br.write("Time:" + " " + current.time);
//        br.newLine();
//        br.write("from" + " " + current.firstCity);
//        br.newLine();
//        br.write("to" + " " + current.secondCity);
//        br.newLine();
//        br.write("Carrier:" + " " + current.carrier);
//        br.newLine();
//        br.write("Price:" + " " + current.price);
//        br.close();
//    }
    public void readFromFile(File file) throws IOException, NullPointerException, Exception {
        Flight fly = new Flight();
        String fileString = new String(Files.readAllBytes(Paths.get("FlightInformation.txt")), StandardCharsets.UTF_8);
        String[] words = fileString.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if ("Date:".equals(words[i])) {
                fly.date.equals(words[i + 1]);
            } else if ("Time:".equals(words[i])) {
                fly.time = Double.valueOf(words[i + 1]);
            } else if ("From".equals(words[i])) {
                fly.firstCity.equals(words[i + 1]);
            } else if ("to".equals(words[i])) {
                fly.secondCity.equals(words[i + 1]);
            } else if ("Carrier:".equals(words[i])) {
                fly.carrier.equals(words[i + 1]);
            } else if ("Price:".equals(words[i])) {
                fly.price = Integer.valueOf(words[i + 1]);
            }

        }
    }
}
