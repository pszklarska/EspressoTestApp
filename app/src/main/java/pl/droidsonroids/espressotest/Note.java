package pl.droidsonroids.espressotest;

public class Note {

    private String mTitle;
    private String mNote;

    public Note(final String title, final String note) {
        mTitle = title;
        mNote = note;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getNote() {
        return mNote;
    }
}
