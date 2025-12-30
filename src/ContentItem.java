public abstract class ContentItem {

    protected int id;
    protected static int idCounter = 1;

    protected String title;
    protected int releaseYear;
    protected int lengthMinutes;

    public ContentItem(String title, int releaseYear, int lengthMinutes) {
        this.id = idCounter++;
        setTitle(title);
        setReleaseYear(releaseYear);
        setLengthMinutes(lengthMinutes);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        int currentYear = java.time.Year.now().getValue();
        if (releaseYear < 1990 || releaseYear > currentYear) {
            throw new IllegalArgumentException("Release year is invalid");
        }
        this.releaseYear = releaseYear;
    }

    public void setLengthMinutes(int lengthMinutes) {
        if (lengthMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero");
        }
        this.lengthMinutes = lengthMinutes;
    }

    public int getAge(int currentYear) {
        return currentYear - releaseYear;
    }

    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return "ID=" + id +
                ", title='" + title + '\'' +
                ", year=" + releaseYear +
                ", duration=" + lengthMinutes + " min";
    }
}
