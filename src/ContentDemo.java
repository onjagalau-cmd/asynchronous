import java.util.ArrayList;
import java.time.Year;

public class ContentDemo {

    public static void main(String[] args) {

        ArrayList<ContentItem> contentList = new ArrayList<>();

        contentList.add(new VideoLecture("Linear Algebra", 2024, 50, "HD"));
        contentList.add(new VideoLecture("Physics Basics", 2021, 70, "4K"));

        contentList.add(new PodcastEpisode("Modern Society", 2023, 40, "John Smith"));
        contentList.add(new PodcastEpisode("Human Psychology", 2022, 90, "Emma Brown"));

        int currentYear = Year.now().getValue();

        for (ContentItem content : contentList) {

            double cost = content.getLicenseCost(currentYear);
            System.out.println(content + " | License cost: " + cost);

            if (content instanceof Downloadable) {
                Downloadable d = (Downloadable) content;
                d.download();
                System.out.println("Daily download limit: " + d.getMaxDownloadsPerDay());
            }

            System.out.println("--------------------------------");
        }
    }
}
