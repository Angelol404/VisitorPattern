import element.File;
import element.Directory;

import visitor.SizeCalculatorVisitor;
import visitor.SearchVisitor;

public class Main {

    public static void main(String[] args) {

        // Create files
        File file1 = new File("report.pdf", 500);
        File file2 = new File("homework.docx", 200);
        File file3 = new File("photo.jpg", 1000);
        File file4 = new File("notes.txt", 100);

        // Create directories
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");
        Directory images = new Directory("Images");

        // Build file system structure
        documents.addElement(file1);
        documents.addElement(file2);

        images.addElement(file3);

        root.addElement(documents);
        root.addElement(images);
        root.addElement(file4);

        // Create SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor =
                new SizeCalculatorVisitor();

        // Calculate total size
        root.accept(sizeVisitor);

        System.out.println("===== SIZE CALCULATOR =====");
        System.out.println(
                "Total size: " + sizeVisitor.getTotalSize() + " KB"
        );

        // Create SearchVisitor
        SearchVisitor searchVisitor =
                new SearchVisitor("report");

        // Search files
        root.accept(searchVisitor);

        System.out.println("\n===== FILE SEARCH =====");

        if (searchVisitor.getFoundFiles().isEmpty()) {
            System.out.println("No files found.");
        } else {
            for (File file : searchVisitor.getFoundFiles()) {
                System.out.println("Found: " + file.getName());
            }
        }
    }
}