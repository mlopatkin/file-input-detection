import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.FileInputStream;
import java.nio.file.Files;

public class JavaProjectPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        try {
            // FileInputStream(File) is detected in java plugins
            Utils.printAndClose("inputJavaPlugin1.txt", new FileInputStream(project.file("inputJavaPlugin1.txt")));
            // FileInputStream(String) is detected in java plugins
            Utils.printAndClose("inputJavaPlugin2.txt",
                    new FileInputStream(project.file("inputJavaPlugin2.txt").getPath()));

            // Files class isn't supported
            Utils.printAndClose("undetected.txt", Files.newInputStream(project.file("undetected.txt").toPath()));
            Utils.printAndClose("undetected.txt", Files.newBufferedReader(project.file("undetected.txt").toPath()));
            System.out.println(Files.readString(project.file("undetected.txt").toPath()));
            System.out.println(String.join(" ", Files.readAllLines(project.file("undetected.txt").toPath())));
            System.out.println(new String(Files.readAllBytes(project.file("undetected.txt").toPath())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
