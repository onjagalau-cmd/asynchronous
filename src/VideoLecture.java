public class VideoLecture extends ContentItem implements Downloadable {

    private String videoQuality;

    public VideoLecture(String title, int year, int durationMinutes, String videoQuality) {
        super(title, year, durationMinutes);
        setVideoQuality(videoQuality);
    }

    public String getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(String videoQuality) {
        if (videoQuality == null || videoQuality.trim().isEmpty()) {
            throw new IllegalArgumentException("Video quality must be provided");
        }
        this.videoQuality = videoQuality;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        int ageBonus = (age <= 2) ? 5 : 2;
        return (0.05 * getLengthMinutes()) + ageBonus;
    }


    @Override
    public void download() {
        System.out.println("Downloading video lecture in " + videoQuality + " quality...");
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() + ", quality='" + videoQuality + "'";
    }
}
