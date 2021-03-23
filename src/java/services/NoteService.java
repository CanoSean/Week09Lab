package services;

import dataaccess.NoteDB;
import dataaccess.UserDB;
import java.util.List;
import models.Notes;
import models.Users;

public class NoteService {
    public Notes get(int id) throws Exception {
        NoteDB noteDB = new NoteDB();
        Notes note = noteDB.get(id);
        return note;
    }
    
    public List<Notes> getAll(String email) throws Exception {
        NoteDB noteDB = new NoteDB();
        List<Notes> notes = noteDB.getAll(email);
        return notes;
    }
    
    public void insert(String title, String contents, String owner) throws Exception {
        Notes note = new Notes(0, title, contents);
        
        UserDB userDB = new UserDB();
        Users user = userDB.get(owner);
        note.setOwner(user);
        
        NoteDB noteDB = new NoteDB();
        noteDB.insert(note);
    }
    
    public void update(int noteId, String title, String contents) throws Exception {
        NoteDB noteDB = new NoteDB();
        Notes note = noteDB.get(noteId);
        note.setTitle(title);
        note.setContents(contents);
        noteDB.update(note);
    }
    
    public void delete(int noteId) throws Exception {
        NoteDB noteDB = new NoteDB();
        Notes note = noteDB.get(noteId);
        noteDB.delete(note);
    }
}
