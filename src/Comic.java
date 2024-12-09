import java.util.List;

public abstract class Comic {
    private String title;
    private int issueNumber;
    private boolean isAvailable;
    private List<String> creators;

    public Comic(String title, int issueNumber, List<String> creators) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.creators = creators;
        this.isAvailable = true;
    }

    // Concrete Methods
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " (Issue " + issueNumber + ") has been borrowed.");
        } else {
            System.out.println(title + " is currently unavailable.");
        }
    }

    public void returnComic() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    // Abstract Method
    public abstract double calculateRarity();

    // Getters for subclass use
    public String getTitle() {
        return title;
    }

    public List<String> getCreators() {
        return creators;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class SuperheroComic extends Comic {
    private int popularityScore;

    public SuperheroComic(String title, int issueNumber, List<String> creators, int popularityScore) {
        super(title, issueNumber, creators);
        this.popularityScore = popularityScore;
    }

    @Override
    public double calculateRarity() {
        return popularityScore * 1.5; // Example rarity calculation
    }
}

class Manga extends Comic {
    private boolean limitedEdition;

    public Manga(String title, int issueNumber, List<String> creators, boolean limitedEdition) {
        super(title, issueNumber, creators);
        this.limitedEdition = limitedEdition;
    }

    @Override
    public double calculateRarity() {
        return limitedEdition ? 50.0 : 20.0; // Higher rarity for limited editions
    }
}
