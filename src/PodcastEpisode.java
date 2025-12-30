public class PodcastEpisode extends ContentItem implements Downloadable {

    private String host;

    public PodcastEpisode(String title, int year, int durationMinutes, String host) {
        super(title, year, durationMinutes);
        setHost(host);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        if (host == null || host.trim().isEmpty()) {
            throw new IllegalArgumentException("Host name cannot be empty");
        }
        this.host = host;
    }

    @Override
    public void download() {
        System.out.println("Downloading podcast hosted by " + host + "...");
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 10;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        double extraFee = (age <= 2) ? 3 : 1;
        return (0.03 * getLengthMinutes()
        ) + extraFee;
    }

    @Override
    public String toString() {
        return super.toString() + ", host='" + host + "'";
    }
}
