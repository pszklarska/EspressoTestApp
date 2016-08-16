package pl.droidsonroids.espressotest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

class NotesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_note_title) TextView mTextViewNoteTitle;
    @BindView(R.id.text_note_message) TextView mTextViewNoteMessage;

    NotesViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(final Note note) {
        mTextViewNoteTitle.setText(note.getTitle());
        mTextViewNoteMessage.setText(note.getNote());
    }
}
